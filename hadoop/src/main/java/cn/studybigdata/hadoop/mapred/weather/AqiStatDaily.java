package cn.studybigdata.hadoop.mapred.weather;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class AqiStatDaily
{
    public static class StatMapper extends Mapper<Object, Text, Text, IntWritable>
    {
        private IntWritable intValue = new IntWritable();
        private Text dateKey = new Text();

        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException
        {
            String[] items = value.toString().split(",");

            String date = items[0];
            String aqi = items[6];

            if(!"DATE".equals(date) && !"N/A".equals(aqi))
            {
                dateKey.set(date);
                intValue.set(Integer.parseInt(aqi));
                context.write(dateKey, intValue);
            }
        }
    }

    public static class StatReducer extends Reducer<Text, IntWritable, Text, IntWritable>
    {
        private IntWritable result = new IntWritable();
        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException
        {
            int aqi_sum = 0;
            int count = 0;

            for(IntWritable val : values)
            {
                aqi_sum += val.get();
                count++;
            }

            int aqi_avg = aqi_sum/count;
            result.set(aqi_avg);
            context.write(key, result);
        }
    }

    public static void main(String args[])
            throws IOException, ClassNotFoundException, InterruptedException
    {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "AqiStatDaily");
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.setInputPaths(job, args[0]);
        job.setJarByClass(AqiStatDaily.class);
        job.setMapperClass(StatMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setPartitionerClass(HashPartitioner.class);
        job.setReducerClass(StatReducer.class);
        job.setNumReduceTasks(Integer.parseInt(args[2]));
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
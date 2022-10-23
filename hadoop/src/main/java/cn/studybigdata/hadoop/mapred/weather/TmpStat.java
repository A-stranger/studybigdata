package cn.studybigdata.hadoop.mapred.weather;

import java.io.IOException;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class TmpStat {
    static class StatMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        private IntWritable intValue = new IntWritable();
        private Text dateKey = new Text();

        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] items = value.toString().split(",");
            String date = items[0];
            String tmp = items[5];
            if (!"DATE".equals(date) && !"N/A".equals(tmp)) {
                dateKey.set(date.substring(0, 6));
                intValue.set(Integer.parseInt(tmp));
                context.write(dateKey, intValue);
            }
        }
    }

    static class StatReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int tmp_sum = 0;
            int count = 0;
            for (IntWritable val : values) {
                tmp_sum += val.get();
                count++;
            }
            int tmp_avg = tmp_sum / count;
            result.set(tmp_avg);
            context.write(key, result);
        }
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "MonthlyAvgTmpStat");
        System.out.println();
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.setInputPaths(job, args[0]);

        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setJarByClass(TmpStat.class);
        job.setMapperClass(StatMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setPartitionerClass(HashPartitioner.class);
        job.setReducerClass(StatReducer.class);
        job.setNumReduceTasks(Integer.parseInt(args[2]));

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }


}

 
 
 
 

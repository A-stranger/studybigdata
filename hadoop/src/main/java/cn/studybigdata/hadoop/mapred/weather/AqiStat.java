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

public class AqiStat
{
    public static final String GOOD = "优";
    public static final String MODERATE = "良";
    public static final String LIGHTLY_POLLUTED = "轻度污染";
    public static final String MODERATELY_POLLUTED = "中度污染";
    public static final String HEAVILY_POLLUTED = "重度污染";
    public static final String SEVERELY_POLLUTED = "严重污染";

    public static class StatMapper extends Mapper<Object, Text, Text, IntWritable>
    {
        private final static IntWritable one = new IntWritable(1);
        private Text cond = new Text();
        // map方法，根据AQI值，将对应空气质量的天数加1
        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException
        {
            String[] items = value.toString().split("\t");
            int aqi = Integer.parseInt(items[1]);

            if(aqi <= 50)
            {
                // 优
                cond.set(GOOD);
            }
            else if(aqi <= 100)
            {
                // 良
                cond.set(MODERATE);
            }
            else if(aqi <= 150)
            {
                // 轻度污染
                cond.set(LIGHTLY_POLLUTED);
            }
            else if(aqi <= 200)
            {
                // 中度污染
                cond.set(MODERATELY_POLLUTED);
            }
            else if(aqi <= 300)
            {
                // 重度污染
                cond.set(HEAVILY_POLLUTED);
            }
            else
            {
                // 严重污染
                cond.set(SEVERELY_POLLUTED);
            }

            context.write(cond, one);
        }
    }
    // 定义reduce类，对相同的空气质量状况，把它们<K,VList>中VList值全部相加
    public static class StatReducer extends Reducer<Text, IntWritable, Text, IntWritable>
    {
        private IntWritable result = new IntWritable();
        public void reduce(Text key, Iterable<IntWritable> values,Context context)
                throws IOException, InterruptedException
        {
            int sum = 0;
            for (IntWritable val : values)
            {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    public static void main(String args[])
            throws IOException, ClassNotFoundException, InterruptedException
    {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "AqiStat");
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.setInputPaths(job, args[0]);
        job.setJarByClass(AqiStat.class);
        job.setMapperClass(StatMapper.class);
        job.setCombinerClass(StatReducer.class);
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
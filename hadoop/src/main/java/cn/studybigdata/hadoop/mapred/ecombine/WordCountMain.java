package cn.studybigdata.hadoop.mapred.ecombine;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration configuration = new Configuration();
        //create a mapreduce job
        Job job = Job.getInstance(configuration);


        job.setJarByClass(WordCountMain.class);

        job.setMapperClass(WordCountMapper.class);
        //<word,1>
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setCombinerClass(WordCountCombiner.class);

        job.setNumReduceTasks(3);
        job.setReducerClass(WordCountReduce.class);
        //<word,3>
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //input path
        //output path
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true);

    }
}

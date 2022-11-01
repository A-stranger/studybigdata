package cn.studybigdata.hadoop.mapred.awordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] wordArray = value.toString().split(" ");

        IntWritable one = new IntWritable(1);

        for (String word : wordArray) {
            context.write(new Text(word), one);
        }
    }
}

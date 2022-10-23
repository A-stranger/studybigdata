package cn.studybigdata.hadoop.mapred.awordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        //<word,1>
        //<word,1>
        //<word,1>


        //<key3 ,value3>
        //<word, [1,1,1]>

        int count = 0;
        for (IntWritable value : values) {
            int i = value.get();
            count += i;
        }


        context.write(key, new IntWritable(count));

    }
}

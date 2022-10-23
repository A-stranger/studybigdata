package cn.studybigdata.hadoop.mapred.awordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 输入：<0, Text>
 *          hello word
 *          hello bigdata
 *          hello spark word
 *
 *
 * 输出：<word, 1>
 *
 *          hello 3
 *          word 2
 *          spark 1
 *          bigdata 1
 *
 */
                                              //<k1,     v1>      <k2,    v2>
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // hello word
        String[] wordArray = value.toString().split(" ");

        // v2
        IntWritable one = new IntWritable(1);

        for (String word : wordArray) {
            //Output <word, 1>
            context.write(new Text(word), one);
        }
    }
}

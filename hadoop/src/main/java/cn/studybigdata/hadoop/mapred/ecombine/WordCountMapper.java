package cn.studybigdata.hadoop.mapred.ecombine;

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
            //没有使用combiner : mapper <a, <1,1,1>>  node0->node1
            //使用了combiner :  mapper <a, <3>>    node0->node1
            context.write(new Text(word), one);
        }
    }
}

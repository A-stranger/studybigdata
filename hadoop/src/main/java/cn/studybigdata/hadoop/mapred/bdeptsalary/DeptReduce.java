package cn.studybigdata.hadoop.mapred.bdeptsalary;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DeptReduce extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
    @Override
    protected void reduce(IntWritable dept, Iterable<IntWritable> salaries, Context context) throws IOException, InterruptedException {

        int total = 0;

        for (IntWritable salary : salaries) {
            int i = salary.get();
            total = total + i;
        }    
    
        context.write(dept, new IntWritable(total));

    }
}

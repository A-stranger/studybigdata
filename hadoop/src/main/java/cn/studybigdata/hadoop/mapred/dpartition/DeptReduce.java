package cn.studybigdata.hadoop.mapred.dpartition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DeptReduce extends Reducer<IntWritable, Employee, IntWritable, Text> {
    @Override
    protected void reduce(IntWritable dept, Iterable<Employee> employees, Context context) throws IOException, InterruptedException {

        for (Employee employee : employees) {
            context.write(dept, new Text(employee.toString()));
        }
    }
}

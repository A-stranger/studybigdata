package cn.studybigdata.hadoop.mapred.cserialize;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DeptReduce extends Reducer<IntWritable, Employee, IntWritable, NullWritable> {
    @Override
    protected void reduce(IntWritable dept, Iterable<Employee> employees, Context context) throws IOException, InterruptedException {

        int total = 0;

        for (Employee employee : employees) {
            int salary = employee.getSalary();
            total = total+salary;
        }

        Class nullWritableClass  = NullWritable.class;
        NullWritable o = null;
        try {
            o = (NullWritable) nullWritableClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }



//        context.write(dept, new IntWritable(total));
        context.write(dept, o);

    }
}

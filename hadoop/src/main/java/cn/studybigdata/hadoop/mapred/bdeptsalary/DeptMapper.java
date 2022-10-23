package cn.studybigdata.hadoop.mapred.bdeptsalary;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DeptMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
    //7369,SMITH,CLERK,7902,1980/12/17,800,,20
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String lineContent = value.toString();
        String[] empArray = lineContent.split(",");

        int dept = Integer.parseInt(empArray[7]);
        int salary = Integer.parseInt(empArray[5]);

        // key: 部门
        // value: 工资
        context.write(new IntWritable(dept), new IntWritable(salary));
    }
}

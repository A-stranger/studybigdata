package cn.studybigdata.hadoop.mapred.gdistinct;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DeptMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    //7369,SMITH,CLERK,7902,1980/12/17,800,,20
    //7499,ALLEN,SALESMAN,7698,1981/2/20,1600,300,30
    //7521,WARD,SALESMAN,7698,1981/2/22,1250,500,30
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //7369,SMITH,CLERK,7902,1980/12/17,800,,20
        String[] tmp = value.toString().split(",");
        // [7369,SMITH,CLERK,7902,1980/12/17,800,,20]

        String empPosition = tmp[2];


        // <CLERK, null>

        // <SALESMAN, null>
        // <SALESMAN, null>
        context.write(new Text(empPosition), NullWritable.get());
    }
}

package cn.studybigdata.hadoop.mapred.gdistinct;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DeptReducer extends Reducer<Text, NullWritable, Text, NullWritable> {

    // <SALESMAN, null>
    // <SALESMAN, null>


    // <SALESMAN, <Null, Null>>
    @Override
    protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {


        context.write(key,NullWritable.get());
        //所有的岗位列表
    }
}

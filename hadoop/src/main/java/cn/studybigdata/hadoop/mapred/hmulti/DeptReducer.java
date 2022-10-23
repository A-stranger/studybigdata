package cn.studybigdata.hadoop.mapred.hmulti;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class DeptReducer extends Reducer<IntWritable, Text, Text, Text> {


    // <deptId, <empName, *deptName> >

    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        String deptName = null;
        ArrayList<String> empList = new ArrayList<>();


        for (Text value : values) {

            String tmp = value.toString();
            if (tmp.contains("*")){
                deptName = tmp;
            }else {
                empList.add(tmp);
            }
        }


        for (String empName : empList) {
            context.write(new Text(deptName.replace("*","")), new Text(empName));
        }

        //<deptName,empName>
    }
}

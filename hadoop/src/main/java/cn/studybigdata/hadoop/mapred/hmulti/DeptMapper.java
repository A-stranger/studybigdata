package cn.studybigdata.hadoop.mapred.hmulti;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DeptMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
    // 7369,SMITH,CLERK,7902,1980/12/17,800,,20
    // 7499,ALLEN,SALESMAN,7698,1981/2/20,1600,300,30
    // 7521,WARD,SALESMAN,7698,1981/2/22,1250,500,30
    // 7566,JONES,MANAGER,7839,1981/4/2,2975,,20
    // 7654,MARTIN,SALESMAN,7698,1981/9/28,1250,1400,30
    // 7698,BLAKE,MANAGER,7839,1981/5/1,2850,,30
    // 7782,CLARK,MANAGER,7839,1981/6/9,2450,,10
    // 7788,SCOTT,ANALYST,7566,1987/4/19,3000,,20
    // 7839,KING,PRESIDENT,,1981/11/17,5000,,10
    // 7844,TURNER,SALESMAN,7698,1981/9/8,1500,0,30
    // 7876,ADAMS,CLERK,7788,1987/5/23,1100,,20
    // 7900,JAMES,CLERK,7698,1981/12/3,950,,30
    // 7902,FORD,ANALYST,7566,1981/12/3,3000,,20
    // 7934,MILLER,CLERK,7782,1982/1/23,1300,,10
    // <deptId, empName>



    // 10,ACCOUNTING,NEW YARK
    // 10,ACCOUNTING,NEW YARK
    // 20,RESEARCH,DALLAS
    // 30,SALES,CHICAGO
    // 40,OPERATIONS,BOSTON
    // <deptId, *DeptName>

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] strings = value.toString().split(",");

        if (strings.length==3){
            // <deptId, *deptName>
            context.write(new IntWritable(Integer.parseInt(strings[0])), new Text("*"+strings[1]));
        }else {
            // <deptId, empName>
            context.write(new IntWritable(Integer.parseInt(strings[7])), new Text(strings[1]));
        }
    }
}

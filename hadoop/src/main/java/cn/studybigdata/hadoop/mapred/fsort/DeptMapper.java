package cn.studybigdata.hadoop.mapred.fsort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DeptMapper extends Mapper<LongWritable, Text, Employee, NullWritable> {
    //7369,SMITH,CLERK,7902,1980/12/17,800,,20
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String lineContent = value.toString();
        // [7369,SMITH,CLERK,7902,1980/12/17,800,,20]
        String[] empArray = lineContent.split(",");

        int empId = Integer.parseInt(empArray[0]);
        String name = empArray[1];
        String position = empArray[2];
        int otherId = -1;
        try {
            otherId = Integer.parseInt(empArray[3]);
        }catch (Exception e){
            System.out.println("员工老板的id没有获取到，使用了前面设置的默认值： -1");
        }
        String hireDate = empArray[4];
        int salary = Integer.parseInt(empArray[5]);
        int bonus = 0;
        try {
            bonus = Integer.parseInt(empArray[6]);
        }catch (Exception e){
            System.out.println("无奖金，bonus设置为零");
        }
        int deptId = Integer.parseInt(empArray[7]);

        Employee employee = new Employee(empId, name, position, otherId, hireDate, salary, bonus, deptId);

        context.write(employee, NullWritable.get());

        //输出到文件
        //员工信息，先按照部门编号排序，再按照员工工资排序
        // <Employee, null>
    }
}

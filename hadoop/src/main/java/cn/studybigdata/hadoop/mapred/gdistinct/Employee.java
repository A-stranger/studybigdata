package cn.studybigdata.hadoop.mapred.gdistinct;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Employee implements WritableComparable<Employee> {
    //员工ID,名字, 职位, otherID,雇佣时间,工资,奖金,部门号
    //7369,SMITH,CLERK,7902,1980/12/17,800,   ,20
    private int empId;
    private String name;
    private String position;
    private int otherId;
    private String hireDate;
    private int salary;
    private int bonus;
    private int deptId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getOtherId() {
        return otherId;
    }

    public void setOtherId(int otherId) {
        this.otherId = otherId;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }


    public Employee() {
    }

    public Employee(int empId, String name, String position, int otherId, String hireDate, int salary, int bonus, int deptId) {
        this.empId = empId;
        this.name = name;
        this.position = position;
        this.otherId = otherId;
        this.hireDate = hireDate;
        this.salary = salary;
        this.bonus = bonus;
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", otherId=" + otherId +
                ", hireDate='" + hireDate + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", deptId=" + deptId +
                '}';
    }


    /**
     * 序列化
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.empId);
        out.writeUTF(this.name);
        out.writeUTF(this.position);
        out.writeInt(this.otherId);
        out.writeUTF(this.hireDate);
        out.writeInt(this.salary);
        out.writeInt(this.bonus);
        out.writeInt(this.deptId);
    }

    /**
     * 反序 列化
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        this.empId = in.readInt();
        this.name = in.readUTF();
        this.position = in.readUTF();
        this.otherId = in.readInt();
        this.hireDate = in.readUTF();
        this.salary = in.readInt();
        this.bonus = in.readInt();
        this.deptId = in.readInt();
    }


    @Override
    public int compareTo(Employee o) {

        //  other -->  this
        //  this --> other
        if (this.deptId > o.deptId) {
            return 1;
        } else if (this.deptId < o.deptId) {
            return -1;
        }

        // 当部门编号相等的时候，比较员工工资
        if (this.salary>o.salary){
            return 1;
        }else {
            return -1;
        }
    }
}

package cn.studybigdata.java.sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;


/**
 * 1. 整型数组排序
 * 2. 自定义类排序（对单个字段排序，对多个字段排序）
 * 3. Hadoop自定义排序
 */
public class Employee implements Comparable<Employee> {
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

    public Employee(int empId, int deptId) {
        this.empId = empId;
        this.deptId = deptId;
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

    public static void main(String[] args) {

        //1. 整型数组排序
        int[] intArray = {5, 2, 7, 9, 1, 0, 6};
        System.out.println("排序前：");
        for (int i : intArray) {
            System.out.print(i);
        }
        //冒泡排序
        //使用Arrays.sort()
        Arrays.sort(intArray);

        System.out.println("排序后:");
        for (int i : intArray) {
            System.out.print(i);
        }


        // 2.Employee类（按照deptId排序）
        Employee zhangsan = new Employee(3, 20);
        Employee lisi = new Employee(5, 10);
        Employee wangwu = new Employee(1, 20);


        Employee[] employees = {zhangsan, lisi, wangwu};

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees);

        for (Employee employee : employees) {
            System.out.println(employee);
        }


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

        // 当部门编号相等的时候，比较员工编号
        if (this.empId>o.empId){
            return 1;
        }else {
            return -1;
        }
    }
}
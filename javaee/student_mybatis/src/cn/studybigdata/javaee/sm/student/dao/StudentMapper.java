package cn.studybigdata.javaee.sm.student.dao;

import java.util.List;

import cn.studybigdata.javaee.sm.student.pojo.Student;

public interface StudentMapper {
	//添加学生信息
	public int addStudent(Student student);
	//更新学生信息
	public int updataStudent(Student student);
	//根据id删除学生信息
	public int deleteStudent(int id);
	//查询所有的学生信息
	public List<Student> query();
	//根据条件查询学生信息
	public List<Student> search(Student student);
	//根据账号和密码判断用户的个数
	public int isExistent(Student student);
}

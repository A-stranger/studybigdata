package cn.studybigdata.javaee.sm.student.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import cn.studybigdata.javaee.sm.student.pojo.Student;
import cn.studybigdata.javaee.sm.student.util.SqlSessionFactoryUtil;


public class StudentDao{

	public int addStudent(Student student) {
		SqlSession sqlSession = null;
		int result = 0;

		try{
			sqlSession = SqlSessionFactoryUtil.openSession();
			StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
			result = studentDao.addStudent(student);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return result;
	}

	public int updataStudent(Student student) {
		int result = 0;
		SqlSession sqlSession = null;

		try{
			sqlSession = SqlSessionFactoryUtil.openSession();
			StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
			result = studentDao.updataStudent(student);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}

		return result;
	}

	public int deleteStudent(int id) {
		int result = 0;
		SqlSession sqlSession = null;

		try{
			sqlSession = SqlSessionFactoryUtil.openSession();
			StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
			result = studentDao.deleteStudent(id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return result;
	}

	public List<Student> search(Student student) {
		SqlSession sqlSession = null;
		List<Student> studentList = null;
		try{
			sqlSession = SqlSessionFactoryUtil.openSession();
			StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
			studentList = studentDao.search(student);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return studentList;
	}

}
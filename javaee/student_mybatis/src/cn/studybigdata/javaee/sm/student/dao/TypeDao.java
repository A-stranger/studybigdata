package cn.studybigdata.javaee.sm.student.dao;

import org.apache.ibatis.session.SqlSession;

import cn.studybigdata.javaee.sm.student.pojo.Type;
import cn.studybigdata.javaee.sm.student.util.SqlSessionFactoryUtil;

public class TypeDao{
	public Type getById(Integer id) {
		SqlSession sqlSession = null;
		Type type = null;
		try{
			sqlSession = SqlSessionFactoryUtil.openSession();
			TypeMapper typeDao = sqlSession.getMapper(TypeMapper.class);
			type = typeDao.getById(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return type;
	}
}
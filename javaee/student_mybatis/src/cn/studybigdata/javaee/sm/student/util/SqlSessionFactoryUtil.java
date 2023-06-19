package cn.studybigdata.javaee.sm.student.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
private static SqlSessionFactory sqlSessionFactory = null;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory!=null){
			return sqlSessionFactory;
		}else{	
			try{
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession(){
		if(sqlSessionFactory==null){
			getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();	
	}
}

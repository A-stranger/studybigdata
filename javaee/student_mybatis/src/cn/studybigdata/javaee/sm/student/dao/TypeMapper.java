package cn.studybigdata.javaee.sm.student.dao;

import cn.studybigdata.javaee.sm.student.pojo.Type;

public interface TypeMapper {
    //根据id查询类型
	public Type getById(Integer id);
}

package com.itheima.mybatis.mapper;

import java.io.IOException;

import com.itheima.mybatis.pojo.User;

public interface UserMapper {
	
	//没有实现类的情况下
		//1：要求接口  的方法名要与Mapper.xml的statement的ID保存一致
		//2：要求接口的方法入参的数据类型要与Mapper.xml 的statement的入参类型要一致
		//3：要求接口的方法返回值的数据类型要与Mapper.xml 的statement的返回值类型要一致
		//4:要求接口的类路径名称要与Mapper的namespace保存一致 
		
		//根据ID查询 用户
		public User findUserById(Integer id)throws Exception;
}

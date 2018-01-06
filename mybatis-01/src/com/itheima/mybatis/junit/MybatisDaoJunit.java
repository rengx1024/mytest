package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.UserDaoImpl;
import com.itheima.mybatis.pojo.User;

public class MybatisDaoJunit {
	
	@Test
	public void testFindUserById() throws Exception {
		
		String resource = "SqlMapperConfig.xml";
		//读取流
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);//Shift + Alt + L
		//打开
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		User user = userDao.findUserById(29);
		System.out.println(user);
	}
}

package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.UserDaoImpl;
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperJunit {
	
	@Test
	public void testFindUserById() throws Exception {
		
		String resource = "SqlMapperConfig.xml";
		//读取流
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);//Shift + Alt + L
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(27);
		System.out.println(user);
		
		
	}
}

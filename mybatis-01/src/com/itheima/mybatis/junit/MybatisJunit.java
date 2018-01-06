package com.itheima.mybatis.junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.pojo.User;

/**
 * mybatis 入门程序初始化
 * 
 * @author Ren
 *
 */
public class MybatisJunit {
	// 工厂
	@Test
	public void testMybatis() throws Exception {
		String resource = "SqlMapperConfig.xml";
		// 读取流
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建工厂
		SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//打开
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		//根据用户id查询一个用户
		User user = sqlSession.selectOne("test.findUserById",24);
		System.out.println(user);
	//	sqlSession.commit();
	//	sqlSession.close();
	}
	
    //  根据用户名称模糊查询
	@Test
	public void testFindUserByUsername() throws Exception {
		
		String resource = "SqlMapperConfig.xml";
		// 读取流
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建工厂
		SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//打开
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		//根据用户名称模糊查询
		List<User> users = sqlSession.selectList("test.findUserByUsername", "张三");
			for (User user : users) {
				System.out.println(user);	
			}
	}
	//添加用户
	//添加用户之后，返回数据库  自增长的ID
	@Test
	public void testAddUser() throws Exception {
		
		String resource = "SqlMapperConfig.xml";
		// 读取流
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建工厂
		SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//打开
		SqlSession sqlSession = SqlSessionFactory.openSession();
		
		//添加用户
		User user = new User();
		user.setUsername("贾克斯");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("暗影岛");
		//返回影响的条数
		int i = sqlSession.insert("test.addUser", user);
		System.out.println(user.getId());
		sqlSession.commit();
		sqlSession.close();
	}
	
	//修改用户
	
	@Test
	public void testUpdateUserById() throws Exception {
		
		String resource = "SqlMapperConfig.xml";
		//读取流
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);//Shift + Alt + L
		//打开
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("李文迪");
		user.setAddress("聊城");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setId(35);
		
		sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
	}
	//删除用户
	@Test
	public void testDeleteUserById() throws Exception {
		
		String resource = "SqlMapperConfig.xml";
		//读取流
		InputStream in = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);//Shift + Alt + L
		//打开
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUserById",33);
		sqlSession.commit();
	}
}

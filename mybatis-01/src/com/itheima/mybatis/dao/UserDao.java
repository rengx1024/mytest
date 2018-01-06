package com.itheima.mybatis.dao;

import java.io.IOException;

import com.itheima.mybatis.pojo.User;

public interface UserDao {

	//根据user查询用户
	public User findUserById(Integer id) throws IOException;
}

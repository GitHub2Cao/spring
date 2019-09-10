package com.softnovo.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softnovo.dal.mapper.UserMapper;
import com.softnovo.domain.User;

@Repository
public class UserDao {
	@Autowired
	private UserMapper userMapper;

	public int getMatchCount(String userName, String password) {
		return userMapper.getMatchCount(userName, password);
	}

	public User findUserByUserName(final String userName) {
		return userMapper.findUserByUserName(userName);
	}

	public int updateLoginInfo(User user) {
		return userMapper.updateLoginInfo(user);
	}
	
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
}

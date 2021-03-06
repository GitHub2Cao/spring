package com.softnovo.service;

import java.util.List;

import com.softnovo.domain.User;

public interface UserService {
	
	public User findUserByUserName(String userName);
	
	public User getByUserId(Integer userId);
	
	public int addUser(User user);
	
	public int addUsers(List<User> users);
	
	public int addUsersWithAnnon(List<User> users);
}

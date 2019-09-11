package com.softnovo.service;

import java.util.List;

import com.softnovo.domain.User;

public interface UserService {
	public int addUser(User user);
	
	public int addUsers(List<User> users);
}

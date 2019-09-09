package com.softnovo.dal.mapper;

import com.softnovo.domain.User;

public interface UserMapper {
	int getMatchCount(String userName, String password);

	User findUserByUserName(String userName);

	int updateLoginInfo(User user);
}

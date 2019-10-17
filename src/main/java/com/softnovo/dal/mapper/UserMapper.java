package com.softnovo.dal.mapper;

import org.apache.ibatis.annotations.Param;

import com.softnovo.domain.User;

public interface UserMapper {
	int getMatchCount(String userName, String password);

	User findUserByUserName(@Param("userName") String userName);

	int updateLoginInfo(User user);

	int addUser(User user);
}

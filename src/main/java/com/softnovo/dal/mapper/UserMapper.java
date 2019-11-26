package com.softnovo.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.softnovo.domain.User;
import com.softnovo.domain.UserNew;

public interface UserMapper {
	int getMatchCount(String userName, String password);

	User findUserByUserName(@Param("userName") String userName);

	int updateLoginInfo(User user);

	int addUser(User user);
	
	int addUserBatch(@Param("users") List<User> users);
	
	
	List<UserNew> selectUserNewById(@Param("id") int id);
}

package com.softnovo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.softnovo.dal.dao.UserDao;
import com.softnovo.domain.User;
import com.softnovo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	public int addUser(User user) {
		LOGGER.info("add user:{}", JSON.toJSONString(user));
		
//		if (user != null && "111".equals(user.getUserName())) {
//			throw new RuntimeException("ttttt");
//		}
		return userDao.addUser(user);
	}
	
	@Transactional
	@Override
	public int addUsers(List<User> users) {
		if (!CollectionUtils.isEmpty(users)) {
			users.stream().forEach(user -> {
				this.addUser(user);
			});
		}
		return 1;
	}
}

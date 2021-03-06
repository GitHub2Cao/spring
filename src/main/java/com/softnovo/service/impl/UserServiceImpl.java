package com.softnovo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.softnovo.dal.dao.UserDao;
import com.softnovo.domain.User;
import com.softnovo.service.UserPP;
import com.softnovo.service.UserService;

@Service
public class UserServiceImpl implements UserService, BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private List<UserPP> userList;
	@Autowired
	private Map<String, UserPP> userMap;
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	public UserServiceImpl() {
		LOGGER.info("UserServiceImpl");
	}
	
	@PostConstruct
	public void ttt1() {
		LOGGER.info("@PostConstruct");
	}
	
	@PreDestroy
	public void ttt2() {
		LOGGER.info("@PreDestroy");
	}
	
	@Override
	@Cacheable(cacheNames = "userNames")
	public User findUserByUserName(String userName) {
		if (StringUtils.isEmpty(userName)) {
			throw new RuntimeException("userName 为空");
		}
		return userDao.findUserByUserName(userName);
	}
	
	@Override
	public User getByUserId(Integer userId) {
		System.out.println("_+_+_+_+_+ getByUserId");
		return null;// userDao.findUserByUserName(userName);
	}

	@Override
	public int addUser(User user) {
		LOGGER.info("add user:{}", JSON.toJSONString(user));
		LOGGER.info("userList:{}", userList);
		LOGGER.info("userMap:{}", userMap);
		if ("111".equals(user.getUserName())) {
			throw new RuntimeException("_+_+_+_+_+_+_+_+_+_+_+_+_+_+ ");
		}
		return userDao.addUser(user);
	}
	
	//@Transactional
	@Override
	public int addUsers(List<User> users) {
		if (!CollectionUtils.isEmpty(users)) {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					users.stream().forEach(user -> {
						addUser(user);
					});
				}
			});
		}
		return 1;
	}
	
	@Transactional
	@Override
	public int addUsersWithAnnon(List<User> users) {
		if (!CollectionUtils.isEmpty(users)) {
			users.stream().forEach(user -> {
				addUser(user);
			});
		}
		return 1;
	}

	@Override
	public void destroy() throws Exception {
		LOGGER.info("destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOGGER.info("afterPropertiesSet");
	}

	@Override
	public void setBeanName(String name) {
		LOGGER.info("setBeanName:{}", name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		LOGGER.info("setBeanFactory:{}");
	}
}

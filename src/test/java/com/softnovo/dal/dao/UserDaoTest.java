package com.softnovo.dal.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softnovo.base.DaoBaseTest;
import com.softnovo.domain.User;

public class UserDaoTest extends DaoBaseTest {
	@Autowired
    private UserDao userDao;

    @Test
    public void addUser() {
    	try {
    		User user = new User();
    		user.setUserName("ccc");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
        	userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

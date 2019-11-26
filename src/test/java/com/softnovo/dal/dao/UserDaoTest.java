package com.softnovo.dal.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softnovo.base.DaoBaseTest;
import com.softnovo.domain.User;
import com.softnovo.domain.UserNew;

public class UserDaoTest extends DaoBaseTest {
	@Autowired
    private UserDao userDao;
//	@Autowired
//	private UserMapper userMapper;
	
	@Test
	public void testSelect() {
		try {
			System.out.println("()()()()()");
			List<UserNew> list = userDao.selectUserNewById(1);
			
			System.out.println("_+_+_+_+_+_+_+_+" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Test
    public void addUser() {
    	try {
    		User user = new User();
    		user.setUserName("cccd");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
        	userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void addUserBatch() {
    	try {
    		List<User> users = new ArrayList<>();
    		User user = new User();
    		user.setUserName("cccdddddd");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
    		users.add(user);
    		user = new User();
    		user.setUserName("cccdddddd");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
    		
    		users.add(user);
    		
        	int result = userDao.addUserBatch(users);
        	System.out.println("_+_+_+_+_+_+" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

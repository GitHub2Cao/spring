package com.softnovo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softnovo.base.ServiceBaseTest;
import com.softnovo.domain.User;
import com.softnovo.service.impl.MailSender;

public class UserServiceTest extends ServiceBaseTest {
	@Autowired
    private UserService userService;
	@Autowired
	private MailSender mailSender;
	
	@Test
	public void mail() {
		try {
			mailSender.sendMail("aaaaaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Test
    public void addUser() {
    	try {
    		User user = new User();
    		user.setUserName("cgm");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
    		userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void addUsers() {
    	try {
    		List<User> users = new ArrayList<>();
    		User user = new User();
    		user.setUserName("cgm");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
    		users.add(user);
    		user = new User();
    		user.setUserName("112");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
    		
    		
    		users.add(user);
    		
    		user = new User();
    		user.setUserName("112");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
    		users.add(user);
    		user = new User();
    		user.setUserName("111");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
    		users.add(user);
    		
    		userService.addUsers(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}

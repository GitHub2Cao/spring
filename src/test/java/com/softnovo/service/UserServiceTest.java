package com.softnovo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.softnovo.base.ServiceBaseTest;
import com.softnovo.common.util.SpringBeanUtil;
import com.softnovo.domain.User;
import com.softnovo.service.impl.MailSender;
import com.softnovo.tttt.Book;
import com.softnovo.tttt.BookFactoryBean;

public class UserServiceTest extends ServiceBaseTest {
	@Autowired
    private UserService userService;
	@Autowired
	private MailSender mailSender;
	
	@Test
	public void tddd() {
		try {
			
			Object bookFactoryBean = SpringBeanUtil.getBean("&book");
			System.out.println("------" + bookFactoryBean);
			
			bookFactoryBean = SpringBeanUtil.getBean("book");
			System.out.println("++++++" + bookFactoryBean);
			
			
//			BookFactoryBean bookFactoryBean = SpringBeanUtil.getBean(BookFactoryBean.class);
//			System.out.println(bookFactoryBean);
//			
//			
//			
//			
//			
//			Book book = bookFactoryBean.getObject();
//			System.out.println(book);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void mail() {
		try {
			mailSender.sendMail("aaaaaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void findUserByUserName() {
		try {
			String userName = "tom";
			User user = userService.findUserByUserName(userName);
			System.out.println("_+_+_+_+_+_+_+_+_+****" + JSON.toJSONString(user));
			
			
			userName = "tom22";
			user = userService.findUserByUserName(userName);
			System.out.println("_+_+_+_+_+_+_+_+_+****" + JSON.toJSONString(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Test
    public void addUser() {
    	try {
    		User user = new User();
    		user.setUserName("cgmdddd");
    		user.setPassword("123456");
    		user.setCredit(1);
    		user.setLastIp("127.0.0.1");
    		user.setLastVisit(new Date());
    		int id = userService.addUser(user);
    		System.out.println("_+_+_+_+_+_+" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void addUsers() {
    	try {
    		String s = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            System.out.println("classpath : ----------------- " + s );
    		
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
    
    @Test
    public void addUsersWithAnnon() {
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
    		
    		userService.addUsersWithAnnon(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}

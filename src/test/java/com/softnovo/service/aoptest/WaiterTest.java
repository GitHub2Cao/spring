package com.softnovo.service.aoptest;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softnovo.base.ServiceBaseTest;
import com.softnovo.service.Waiter;
import com.softnovo.service.aop.GreetingBeforeAdvice;

public class WaiterTest extends ServiceBaseTest {
	@Autowired
	private Waiter waiter;
	
	@Test
	public void test() {
		try {
			//waiter.greetTo("hhh");
			waiter.serveTo("hhh");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
		try {
			BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
			ProxyFactory pf = new ProxyFactory();
			pf.setTarget(waiter);
			pf.addAdvice(beforeAdvice);
			
			Waiter proxy = (Waiter) pf.getProxy();
			
			
			proxy.greetTo("hhh");
			proxy.serveTo("hhh");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

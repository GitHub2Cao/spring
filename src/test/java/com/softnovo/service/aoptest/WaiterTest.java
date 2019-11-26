package com.softnovo.service.aoptest;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softnovo.base.ServiceBaseTest;
import com.softnovo.service.Seller;
import com.softnovo.service.Waiter;
import com.softnovo.service.aop.GreetingBeforeAdvice;

public class WaiterTest extends ServiceBaseTest {
	@Autowired
	private Waiter waiter;
//	@Resource
//	private NaiveWaiterImpl naiveWaiterImpl;
	
	@Test
	public void testEnable() {
		try {
			waiter.greetTo("aaa");
			Seller sss = (Seller) waiter;
			sss.sell("bbb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		try {
			//naiveWaiterImpl.greetTo("greetTo");
			waiter.serveTo("serveTo123");
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

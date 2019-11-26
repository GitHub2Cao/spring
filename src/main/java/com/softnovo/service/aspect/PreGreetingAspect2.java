package com.softnovo.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

//@Service
@Aspect
@Order(2)
public class PreGreetingAspect2 {
	@Before("execution(* greetTo(..))")
	public void beforeGreeting() {
		System.out.println("How are you!!!2222");
	}
	

}
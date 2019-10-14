package com.softnovo.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Order(1)
public class PreGreetingAspect {
	@Before("NamePointcut.greetTo()")
	public void beforeGreeting() {
		System.out.println("How are you!!!");
	}
	
	@Before("execution(* sell(..))")
	public void beforesell() {
		System.out.println("2222!!!");
	}

}

package com.softnovo.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Order(1)
public class PreGreetingAspect {
	@Before("execution(* serveTo(..))")
	public void serveTo() {
		System.out.println("How are you!!! serveTo");
	}
	
	@Before("execution(* greetTo(..))")
	public void greetTo() {
		System.out.println("How are you!!! greetTo");
	}
	
//	@Before("execution(* sell(..))")
//	public void beforesell() {
//		System.out.println("2222!!!");
//	}

}

package com.softnovo.service.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class NamePointcut {
	@Pointcut("execution(* greetTo(..))")
	public void greetTo() {}

}

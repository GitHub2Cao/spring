package com.softnovo.service.springbase;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;

public class DefaultSmartLifecycle implements SmartLifecycle, ApplicationContextAware {

	@Override
	public void start() {
		System.out.println("start--------------------");

        
	}

	@Override
	public void stop() {
		
	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		A a = applicationContext.getBean(A.class);
		System.out.println("aaaaaaaaaaaaaa ==== " + a);
		System.out.println("aaaaaaaaaaaaaa ==== " + a.b);
	}

}

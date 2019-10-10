package com.softnovo.service.impl;

import org.springframework.stereotype.Service;

import com.softnovo.service.Waiter;
import com.softnovo.service.aop.BeanSelfProxyAware;

@Service
public class NaiveWaiter implements Waiter, BeanSelfProxyAware {
	private Waiter waiter;
	
	@Override
	public void greetTo(String name) {
		System.out.println("greetTo " + name);
	}

	@Override
	public void serveTo(String name) {
		System.out.println("serveTo " + name);
		greetTo(name);
	}

	@Override
	public void setSelfProxy(Object object) {
		waiter = (Waiter) object;
	}
}

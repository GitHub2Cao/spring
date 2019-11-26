package com.softnovo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softnovo.service.Waiter;

//@Service
public class NaiveWaiterImpl implements Waiter {
	@Resource
	private Waiter waiter;

	@Override
	public void greetTo(String name) {
		waiter.greetTo(name);
	}

	@Override
	public void serveTo(String name) {
		waiter.serveTo(name);
	}

}

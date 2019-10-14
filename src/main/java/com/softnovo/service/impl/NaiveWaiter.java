package com.softnovo.service.impl;

import org.springframework.stereotype.Service;

import com.softnovo.service.Waiter;

@Service
public class NaiveWaiter implements Waiter {
	
	@Override
	public void greetTo(String name) {
		System.out.println("greetTo " + name);
	}

	@Override
	public void serveTo(String name) {
		System.out.println("serveTo " + name);
		//greetTo(name);
	}
}

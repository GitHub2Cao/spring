package com.softnovo.service.springbase;

import org.springframework.context.SmartLifecycle;

public class DefaultSmartLifecycle implements SmartLifecycle{

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

}

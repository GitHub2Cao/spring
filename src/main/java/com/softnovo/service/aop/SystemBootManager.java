
package com.softnovo.service.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

//@Component
public class SystemBootManager implements ApplicationListener<ContextRefreshedEvent> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
	}
}

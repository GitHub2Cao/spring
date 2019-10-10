package com.softnovo.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.softnovo.tttt.event.MailSendEvent;

@Service
public class MailSender implements ApplicationContextAware {
	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}
	
	
	public void sendMail(String to) {
		System.out.println("()()()()()");
		MailSendEvent mse = new MailSendEvent(this.ctx, to);
		ctx.publishEvent(mse);
	}

}

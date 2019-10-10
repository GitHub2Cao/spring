package com.softnovo.tttt.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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

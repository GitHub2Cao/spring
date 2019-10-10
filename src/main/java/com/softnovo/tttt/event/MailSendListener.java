package com.softnovo.tttt.event;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent>{

	@Override
	public void onApplicationEvent(MailSendEvent event) {
		MailSendEvent mse = event;
		System.out.println("+++++++_+_+_+_+_+ " + mse.getTo());
	}
}

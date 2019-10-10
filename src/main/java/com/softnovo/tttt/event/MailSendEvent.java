package com.softnovo.tttt.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MailSendEvent extends ApplicationContextEvent {
	private static final long serialVersionUID = 2988816801028366558L;
	
	public MailSendEvent(ApplicationContext source) {
		super(source);
	}
	
	public MailSendEvent(ApplicationContext source, String to) {
		super(source);
		this.to = to;
	}

	private String to;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTo() {
		return to;
	}
}

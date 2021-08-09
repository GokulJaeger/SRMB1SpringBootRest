package com.org.qualifiers.assessment1.messageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageProcessorImpl implements MessageProcessor {

	private MessageService messageService;

@Autowired
	public MessageProcessorImpl(@Qualifier("smsService") MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void processMsg(String message) {
		messageService.sendMsg(message);
	}
}

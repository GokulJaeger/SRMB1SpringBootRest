package com.org.qualifiers.assessment1.messageservice;

public class SMSService implements MessageService{

	public void sendMsg(String message) {
		System.out.println("SMS Message: " + message);
	}

}

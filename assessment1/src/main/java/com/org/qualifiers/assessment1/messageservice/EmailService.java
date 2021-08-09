package com.org.qualifiers.assessment1.messageservice;

public class EmailService implements MessageService{

	public void sendMsg(String message) {
		System.out.println("Your Email: " + message);
	}

}

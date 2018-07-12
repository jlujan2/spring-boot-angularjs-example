package com.javainuse;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.javainuse.entity.Email;

@Component
public class Reciever {

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(Email email) {
		System.out.println("Received <"+ email+ ">");
	}
}

package com.jms.dev.reciver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.jms.dev.bean.Person;

@Component
public class JmsMessageReceiver {
	@Autowired
	private JmsTemplate jmsTemplate;

	public Person receive() throws JMSException {
		Message message = jmsTemplate.receive();
		ObjectMessage objectMessage = (ObjectMessage) message;
		Person person = (Person) objectMessage.getObject();
		System.out.println("Received  : " + person);
		return person;

	}

}

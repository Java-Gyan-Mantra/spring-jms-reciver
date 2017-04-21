package com.jms.dev.service;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jms.dev.bean.Person;
import com.jms.dev.reciver.JmsMessageReceiver;

@Service
public class ReciverService {
	@Autowired
	private JmsMessageReceiver receiver;

	public List<Person> reciveJMSMsg() throws JMSException {
		List<Person> persons = new ArrayList<>();
		Person person = receiver.receive();
		persons.add(person);
		return persons;
	}
}

package com.jms.dev.controller;

import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jms.dev.bean.Person;
import com.jms.dev.service.ReciverService;

@Controller
public class JMSReciverController {
	@Autowired(required = true)
	private ReciverService service;

	@RequestMapping(value = "/callJmsSender")
	public String getPersons(Model model) {
		try {
			List<Person> persons = service.reciveJMSMsg();
			model.addAttribute("persons", persons);
		} catch (JMSException e) {
			// add logger here
		}
		return "fetch_jms_data";
	}
}

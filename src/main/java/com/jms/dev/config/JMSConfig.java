package com.jms.dev.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
@PropertySource("classpath:application.properties")
public class JMSConfig {
	@Autowired(required = true)
	private Environment env;

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(env
				.getProperty(PropertyConstants.BROKER_URL));
		connectionFactory.setPassword(env
				.getProperty(PropertyConstants.BROKER_PASSWORD));
		connectionFactory.setUserName(env
				.getProperty(PropertyConstants.BROKER_USERNAME));
		return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName("person.queue");
		return template;
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("1-1");
		return factory;
	}

}

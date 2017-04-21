package com.jms.dev.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JMSAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("JMSConfig Loaded..");
		return new Class[] { JMSConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("MvcConfig Loaded..");
		return new Class[] { MvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

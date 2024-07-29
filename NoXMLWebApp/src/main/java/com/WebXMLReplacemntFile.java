package com;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXMLReplacemntFile extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		Class[] configClassArray = { ConfigClass.class };
		return configClassArray;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlMappings = { "/travels/*" };
		return urlMappings;
	}

}

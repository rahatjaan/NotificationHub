package com.servercentral.communication.hub.job;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring\\spring-config.xml");
	///	new ClassPathXmlApplicationContext("schedule-basicUsageFixedDelay-example.xml");
	//	new ClassPathXmlApplicationContext("schedule-xmlConfig-example.xml");
	//	new ClassPathXmlApplicationContext("schedule-PropertiesConfig-example.xml");
	}	
}

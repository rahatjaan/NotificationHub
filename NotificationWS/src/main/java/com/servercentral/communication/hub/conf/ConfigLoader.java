package com.servercentral.communication.hub.conf;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.description.AxisService;

public class ConfigLoader {

	static Properties props = new Properties();
	static final String DB_URL="db.url";
	static final String DB_USER="db.user";
	static final String DB_PASSWORD="db.password";
	static{

		try {
//			AxisService axisService = MessageContext.getCurrentMessageContext().getAxisService();
//	        ClassLoader serviceClassLoader = axisService.getClassLoader();
//	        URL configURL = serviceClassLoader.getResource("hibernate.cfg.xml");
//	        System.out.println("hibernate.cfg.xml:"+configURL.toString());
//			configuration.configure(configFile);
	        
			props.load(ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties"));
			System.out.println("properties laded:"+getString("db.url"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public static String getString(String key) {
		return props.getProperty(key);
	}
	
	public static String getDbUrl(){
		return getString(DB_URL);
				
	}
	public static String getDbUser(){
		return getString(DB_USER);
				
	}
	public static String getDbPassword(){
		return getString(DB_PASSWORD);
				
	}
}

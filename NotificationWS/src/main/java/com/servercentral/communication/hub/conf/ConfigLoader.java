package com.servercentral.communication.hub.conf;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	static Properties props = new Properties();
	static final String DB_URL="db.url";
	static final String DB_USER="db.user";
	static final String DB_PASSWORD="db.password";
	static final String SMTP_USER="smtp.username";
	static final String SMTP_PASSWORD="smtp.password";
	static{

		try {
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
	public static String getSMTPUser(){
		return getString(SMTP_USER);
				
	}
	public static String getSMTPPassword(){
		return getString(SMTP_PASSWORD);
				
	}
}

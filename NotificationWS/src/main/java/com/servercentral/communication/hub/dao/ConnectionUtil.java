package com.servercentral.communication.hub.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.servercentral.communication.hub.conf.ConfigLoader;

public class ConnectionUtil {

	static String userName= "root";
	static String password="";
	private static String dburl = "jdbc:mysql://localhost:3306/communication_hub";
	static boolean initialized = false;
	public static void main(String []args){
		try {
			getConnection();
			System.out.println("connection established");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static Connection getConnection() throws SQLException {
		if(!initialized)
			initProperties();
	    Connection conn = null;
	    
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", userName);
	    connectionProps.put("password", password);
	    try {
	    	System.out.println("loading jdbc driver class");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loaded class");
		} catch (ClassNotFoundException e) {
			System.out.println("loading jdbc driver class causes exception");
			e.printStackTrace();
		}
	    conn = DriverManager.getConnection(dburl,connectionProps);
	    System.out.println("Connected to database");
	    return conn;
	}


	private static void initProperties() {
		try{
		dburl = ConfigLoader.getDbUrl();
		userName = ConfigLoader.getDbUser();
		password = ConfigLoader.getDbPassword();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

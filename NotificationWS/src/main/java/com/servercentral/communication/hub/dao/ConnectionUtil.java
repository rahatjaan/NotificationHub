package com.servercentral.communication.hub.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	static String dbms = "mysql";
	static String userName= "root";
	static String password="";
	static String serverName="localhost";
	static String portNumber="3306";
	static String dbName="learning";
	private static String db="communication_hub";
	
	public static void main(String []args){
		try {
			getConnection();
			System.out.println("connection established");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static boolean closeConnection(Connection connection) throws SQLException{
		connection.close();
		return true;
	}
	public static Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", userName);
	    connectionProps.put("password", password);

	    if (dbms.equals("mysql")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + dbms + "://" +
	                   serverName +
	                   ":" + portNumber + "/"+db,
	                   connectionProps);
	    } else if (dbms.equals("derby")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + dbms + ":" +
	                   dbName +
	                   ";create=true",
	                   connectionProps);
	    }
	    System.out.println("Connected to database");
	    return conn;
	}

}

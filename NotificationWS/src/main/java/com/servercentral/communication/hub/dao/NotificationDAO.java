package com.servercentral.communication.hub.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NotificationDAO {

	public boolean saveNotification() throws SQLException{
		Connection conn = ConnectionUtil.getConnection();
		conn.createStatement();
		return true;
		
	}
	
	public boolean createDBSchema(){
		return true;
	}
}

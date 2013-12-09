package com.servercentral.communication.hub.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.servercentral.communication.hub.model.Notification;

public class NotificationDAO {

	public boolean saveNotification(Notification notification) throws SQLException{
		Connection conn = ConnectionUtil.getConnection();
		Statement stmt= conn.createStatement();
		String sql = "";
		stmt.executeUpdate(sql);
		return true;
		
	}
	
	public boolean createDBSchema(){
		return true;
	}
}

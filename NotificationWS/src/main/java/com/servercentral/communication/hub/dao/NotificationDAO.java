package com.servercentral.communication.hub.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.servercentral.communication.hub.model.Notification;

public class NotificationDAO {

	public boolean saveNotification(Notification notification) throws SQLException{
		Connection conn = ConnectionUtil.getConnection();
		Statement stmt = null;
		try{
		stmt= conn.createStatement();
		String sql = "INSERT INTO communication_hub.notifications(notification_subject,notification_to,notification_from,messageBody,recipient_guid)" +
				"VALUES('"+notification.getSubject()+"','"+notification.getTo()+"','"+notification.getFrom()+"','"+notification.getMessageBody()+"','"+notification.getRecipientGuid()+"')";
		stmt.executeUpdate(sql);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		}
		return true;
	}
	
	public boolean createDBSchema(){
		return true;
	}
}

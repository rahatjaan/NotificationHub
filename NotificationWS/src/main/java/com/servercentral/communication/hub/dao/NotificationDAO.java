package com.servercentral.communication.hub.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.servercentral.communication.hub.model.Notification;
import com.servercentral.communication.hub.util.DateUtil;

public class NotificationDAO {

	public boolean saveNotification(Notification notification)
			throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO communication_hub.notifications(notification_subject,notification_to,notification_from,messageBody,receiver_guid,receiver_tenant_guid,sender_guid,sender_tenant_guid,received_date,forwardDate,forwardEmail,forward,messagetype)"
					+ "VALUES('"
					+ notification.getSubject()
					+ "','"
					+ notification.getTo()
					+ "','"
					+ notification.getFrom()
					+ "','"
					+ notification.getMessageBody()
					+ "','"
					+ notification.getReceiverGUID()
					+ "','"
					+ notification.getReceiverTenantGuid()
					+ "','"
					+ notification.getSenderGUID()
					+ "','"
					+ notification.getSenderTenantGUID()
					+ "','"
					+ DateUtil.getShortDate(notification.getReceivedDate())
					+ "','"
					+ DateUtil.getShortDate(notification.getForwardDate())
					+ "','"
					+ notification.getForwardEmail()
					+ "',"
					+ notification.getForward()
					+ ","
					+ notification.getMessageType() + ")";
			System.out.println("Sql:"+sql);
			int rows = stmt.executeUpdate(sql);
			System.out.println("saved "+rows);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return true;
	}

	public boolean createDBSchema() {
		return true;
	}
}

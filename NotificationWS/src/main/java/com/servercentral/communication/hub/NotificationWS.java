package com.servercentral.communication.hub;

import java.sql.SQLException;

import com.servercentral.communication.hub.dao.NotificationDAO;
import com.servercentral.communication.hub.model.Notification;
import com.servercentral.communication.hub.util.EmailUtil;

public class NotificationWS{

	public boolean sendNotification(Notification notification){
		System.out.println("Notification WS");
		NotificationDAO dao = new NotificationDAO();
		try {
			boolean saved = dao.saveNotification(notification);
			if(notification.getForward()==1){
				EmailUtil.sendEmail(notification.getForwardEmail());
			}
			return saved;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
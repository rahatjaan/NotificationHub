package com.servercentral.communication.hub;

import com.servercentral.communication.hub.model.Notification;

public class NotificationWS{

	public boolean sendNotification(Notification notification){
		System.out.println("Notification WS");
		return true;
	}
}
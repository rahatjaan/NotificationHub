package com.servercentral.communication.hub.util;
import javax.mail.Message;

import com.servercentral.communication.hub.email.impl.EmailService;
import com.servercentral.communication.hub.model.Notification;
import com.servercentral.communication.hub.utils.email.NotificationEmail;
import com.servercentral.communication.hub.utils.email.IEmailService;


public class EmailUtil {

	public static void sendEmail(Notification notification) {
		try {
			IEmailService emailService = new EmailService();
			Message email = null;
			email = emailService.createEmail(new NotificationEmail(notification));
			emailService.send(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

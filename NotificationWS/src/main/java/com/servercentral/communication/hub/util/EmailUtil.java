package com.servercentral.communication.hub.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {

	public static void main(String[] args) {
		sendEmail("ali_bscs@hotmail.com");
	
	}
	public static void sendEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println("In main method");
		final String username = "username@gmail.com";
		final String password = "password";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
										protected PasswordAuthentication getPasswordAuthentication() {
						                    return new PasswordAuthentication("vehiclechecklist@gmail.com", "vehiclechecklist777");
						                }
					            });

 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ali_1576@yahoo.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Testing Subject");
			Multipart mp = new MimeMultipart();
			MimeBodyPart htmlPart = new MimeBodyPart();
			String text = "<p><font color='red'>This is some text!</font></p><p><b>Note:</b> If using color names, different browsers may render different colors, and Firefox have problems if the attribute value is in RGB code (will not display correct color).</p><p><b>Tip:</b> To produce equal results in all browsers, always use hex code to specify colors.</p><p>However, the color attribute was deprecated in HTML 4, and is not supported in HTML 4.01 Strict DTD or in XHTML 1.0 Strict DTD. Use CSS instead.</p>";
			htmlPart.setContent(text, "text/html");
			mp.addBodyPart(htmlPart);
			message.setContent(mp);
			message.saveChanges();
			//message.setText("<html><body><p><font color='red'>This is some text!</font></p><p><b>Note:</b> If using color names, different browsers may render different colors, and Firefox have problems if the attribute value is in RGB code (will not display correct color).</p><p><b>Tip:</b> To produce equal results in all browsers, always use hex code to specify colors.</p><p>However, the color attribute was deprecated in HTML 4, and is not supported in HTML 4.01 Strict DTD or in XHTML 1.0 Strict DTD. Use CSS instead.</p></body></html>");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

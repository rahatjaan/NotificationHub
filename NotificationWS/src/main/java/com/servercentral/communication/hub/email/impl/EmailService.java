package com.servercentral.communication.hub.email.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.servercentral.communication.hub.conf.ConfigLoader;
import com.servercentral.communication.hub.utils.email.AbstractEmail;
import com.servercentral.communication.hub.utils.email.IEmailService;


public class EmailService implements IEmailService {	
	private static Handlebars handleBars;
	
	public Message createEmail(AbstractEmail source) {
		HashMap<String, String> vals = new HashMap<String, String>();
		vals = source.addBaseURL(vals);
		vals = source.addSubject(vals);
		vals = source.addTitle(vals);
		vals = source.addLink(vals);
		vals = source.addLinkText(vals);
		vals = source.addImageText(vals);
		vals = source.addProperties(vals);
		
		// Translate Email Body
		Handlebars handlebars = getDefaultHandlebars();

		//MultiPartEmail email = new MultiPartEmail();
//		Config config = ConfigurationUtil.config();
		String message=null;
		try {
			Template template = handlebars.compile(source.getEmailTemplateName());
			message = template.apply(vals);
		} catch (IOException e) {
//			throw new MotivosityException("email.templateinvalid");
			e.printStackTrace();
		}
			
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
			
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
				protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(ConfigLoader.getSMTPUser(), ConfigLoader.getSMTPPassword());
                }
            });

	        Message emailMessage = new MimeMessage(session);
			Multipart multiPart = new MimeMultipart("alternative");

			try {

			    MimeBodyPart textPart = new MimeBodyPart();
			    textPart.setText(source.getPlainTextPart(), "utf-8");

			    MimeBodyPart htmlPart = new MimeBodyPart();
			    htmlPart.setContent(message, "text/html; charset=utf-8");

			    multiPart.addBodyPart(textPart);
			    multiPart.addBodyPart(htmlPart);
			    emailMessage.setContent(multiPart);
			    emailMessage.setFrom(new InternetAddress(ConfigLoader.getString("smtp.defaultFrom")));
			    emailMessage.setReplyTo(new InternetAddress[]{new InternetAddress(ConfigLoader.getString("smtp.defaultFrom"), ConfigLoader.getString("application.appName"))});
			    
			    InternetAddress[] toAddresses = { new InternetAddress(source.getNotification().getForwardEmail(), source.getNotification().getForwardEmail()) };
			    emailMessage.setSubject(vals.get("subject"));

			    emailMessage.setRecipients(Message.RecipientType.TO, toAddresses);
			    emailMessage.setSentDate(new Date());
	
	
			} catch (Exception e) {

			    //TODO - do better e-mail error handling
			} 

	    return emailMessage;
	}

	private Handlebars getDefaultHandlebars() {
		if (handleBars == null) {
			ClassPathTemplateLoader loader = new ClassPathTemplateLoader();
			loader.setPrefix("/com/notificationhub/templates/email");
			loader.setSuffix(".handlebars.html");
			handleBars = new Handlebars(loader);
			// handleBars.registerHelper("message", new
			// MessageSourceHelper(messageSource));
		}
		return handleBars;
	}

	
	public void send(Message emailMessage) throws EmailException {
//	    if (StringUtils.isBlank(System.getProperty("profile.name")) || StringUtils.equals(System.getProperty("profile.name"), "dev")) {
//	    	log.error("emailMessage.getMimeMessage().getContent().toString()");
//	    	return;
//	    }
	    try {
			Transport.send(emailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	
	public void send(MultiPartEmail emailMessage) throws EmailException {
	    if (StringUtils.isBlank(System.getProperty("profile.name")) || StringUtils.equals(System.getProperty("profile.name"), "dev")) {
	    	return;
	    }
	    emailMessage.send();
	}


}
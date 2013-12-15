package com.servercentral.communication.hub.utils.email;

import java.util.HashMap;

import com.servercentral.communication.hub.model.Notification;

public class NotificationEmail extends AbstractEmail {


	public NotificationEmail(Notification notification) {
		super(notification);
	}


	@Override
	public HashMap<String, String> addProperties(HashMap<String, String> vals) {
		vals.put("message_1", "Test Notification Message");
		vals.put("message_2", "This is Test Notification Message from Notification Hub");
		return vals;
	}

	@Override
	public String getLink() {
		return "Place your base url here";
	}


	@Override
	public String getLinkText() {
		return "Test Link";
	}


	@Override
	public String getSubject() {
		return "Test Email from Notification Hub";
	}


	@Override
	public String getTitle() {
//		return LocalizationUtil.findLocalizedString(getLocale(), "signupemail.title.text");
		return "Test Email from Notification Hub";
	}


	@Override
	public String getEmailTemplateName() {
		return "two-pgph-link";
	}

	@Override
	public String getPlainTextPart() {
		
		String plainmsg = "This is test Message";
	
		return plainmsg;
	}

	@Override
	public HashMap<String, Object> addPropertiesAsObject(
			HashMap<String, Object> vals) {
		// TODO Auto-generated method stub
		return null;
	}

}

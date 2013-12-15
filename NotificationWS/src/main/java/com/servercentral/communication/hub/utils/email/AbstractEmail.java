/**
 * 
 */
package com.servercentral.communication.hub.utils.email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.github.jknack.handlebars.Handlebars;
import com.servercentral.communication.hub.model.Notification;

/**
 * @author Rahat
 *
 */

public abstract class AbstractEmail {
	
	private List<Notification> notifications;
	private Locale locale;
	private static Handlebars handleBars;

	public AbstractEmail(Notification notification) {
		this.notifications = new ArrayList<Notification>();
		if (notification != null) {
			notifications.add(notification);
		}
	}
	
	public AbstractEmail(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public Locale getLocale() {
/*		if (locale != null) return locale;
		locale = users.get(0).getLocale();
		if (locale == null) {
			locale = Faces.getLocale();
		}
		return locale;*/
		return null;
	}
	
	public abstract HashMap<String, String> addProperties(HashMap<String, String>vals);
	public abstract HashMap<String, Object> addPropertiesAsObject(HashMap<String, Object>vals);
	
	public abstract String getLink();
	public abstract String getLinkText();
	public abstract String getSubject();
	public abstract String getTitle();
	public abstract String getEmailTemplateName();
	public abstract String getPlainTextPart();

	
	public HashMap<String, String> addBaseURL(HashMap<String, String>vals) {
		vals.put("baseURL", getBaseURL());
		return vals;	
	}
	public HashMap<String, String> addSubject(HashMap<String, String>vals) {
		vals.put("subject", getSubject());
		return vals;	
	}

	public HashMap<String, String> addTitle(HashMap<String, String>vals) {
		vals.put("title", getTitle());
		return vals;	
	}
	
	public HashMap<String, String> addLink(HashMap<String, String>vals) {
		vals.put("link", getLink());
		return vals;	
	}

	public HashMap<String, String> addLinkText(HashMap<String, String>vals) {
		vals.put("link_text", getLinkText());
		return vals;	
	}
	
	public String getBaseURL() {
		//return ConfigurationUtil.getBaseUrl();
		return null;
	}
	
	public String getImageText() {
		return "";
	}
	

	public void setToNotification(Notification notification) {
		this.notifications = new ArrayList<Notification>();
		notifications.add(notification);
	}
	
	public Notification getNotification() {
		if (notifications != null) return notifications.get(0);
		return null;
	}
	
	public void addToUsers(MultiPartEmail email) throws EmailException {
		if (notifications.size() == 1) {
			email.addTo(notifications.get(0).getForwardEmail());
		} else {
			for (Notification notification: notifications) {
				email.addBcc(notification.getForwardEmail());
			}
		}
	}
	
	protected void addValFromMsgKey(HashMap<String, String>vals, String key, String msg, Object... msgArgs) {
		if (key != null) {
			//vals.put(key, LocalizationUtil.findLocalizedString(locale, msg, msgArgs));
		}
	}
	
	public HashMap<String, String> addImageText(HashMap<String, String>vals) {
		vals.put("image",  getImageText());
		return vals;
	}
	
}

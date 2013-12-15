package com.servercentral.communication.hub.utils.email;

import java.io.IOException;

import javax.mail.Message;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public interface IEmailService {
//	@Deprecated
//	public HtmlEmail createBaseSimpleEmail() throws EmailException;
//
//	@Deprecated
//	public HtmlEmail createEmail(String subject, String templateName,
//			Object model) throws EmailException, IOException;

	public Message createEmail(AbstractEmail source) throws EmailException, IOException;

	public void send(Message email) throws EmailException;
	public void send(MultiPartEmail email) throws EmailException;

}

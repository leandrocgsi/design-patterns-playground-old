package br.com.erudio;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailUtils implements Serializable {

	private String hostname;
	private String username;
	private String password;
	private String from;
	private int port;
	private boolean ssl;
	private String subject;
	private String message;
	
	private MultiPartEmail getEmailSession(EMailConfigs configs) throws EmailException {
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(hostname);
		email.setSmtpPort(port);
		email.setAuthentication(username, password);
		email.setSSL(ssl);
		email.setFrom(from);
		return email;
	}

	private EmailAttachment attachFile(String fileDir) {
		File file = new File(fileDir);
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(file.getPath());
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Attachment");
		attachment.setName(file.getName());
		return attachment;
	}

	private void sendSimpleMail(EMailConfigs configs, String to) throws EmailException, AddressException {
		MultiPartEmail email = setConfigs(configs, to);
		email.send();
	}

	private void sendEmailWithAttachment(EMailConfigs configs, String to, String filePath) throws EmailException, AddressException {
		MultiPartEmail email = setConfigs(configs, to);
		EmailAttachment attach = attachFile(filePath);
		email.attach(attach);
		email.send();
	}

	private MultiPartEmail setConfigs(EMailConfigs configs, String to) throws EmailException, AddressException {
		MultiPartEmail email = new MultiPartEmail();
		email = getEmailSession(configs);
		email.setSubject(subject);
		email.setMsg(message);
		email.setTo(getRecipients(to));
		return email;
	}
	
	private ArrayList getRecipients(String to) throws AddressException {
		String tosWithoutSpaces = to.replaceAll("\\s","");;
		StringTokenizer tok = new StringTokenizer(tosWithoutSpaces,";");
		ArrayList recipients = new ArrayList();
		while(tok.hasMoreElements()) {
			String string = tok.nextElement().toString();
			recipients.add(new InternetAddress(string));
		}
		return recipients;
	}

	public EmailUtils withHostname(String hostname) {
		this.hostname = hostname;
		return this;
	}

	public EmailUtils withUsername(String username) {
		this.username = username;
		return this;
	}

	public EmailUtils withPassword(String password) {
		this.password = password;
		return this;
	}

	public EmailUtils from(String from) {
		this.from = from;
		return this;
	}

	public EmailUtils usingPort(int port) {
		this.port = port;
		return this;
	}

	public EmailUtils withSsl(boolean ssl) {
		this.ssl = ssl;
		return this;
	}

	public EmailUtils withSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public EmailUtils withMessage(String message) {
		message = message;
		return this;
	}
}
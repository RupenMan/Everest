package edu.mum.everest.email;

/**
 * 
 * @author netra
 */
public class EmailMessage {
	private String recipient;
	private String sender;
	private String content;
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "EmailMessage [recipient=" + recipient + ", sender=" + sender + ", content=" + content + ", subject="
				+ subject + "]";
	}
}
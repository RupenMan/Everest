package edu.mum.everest.email;

/**
 * 
 * @author netra
 */
public class EmailMessageBuilder {
	private EmailMessage email;

	private EmailMessageBuilder(EmailMessage email) {
		this.email = email;
	}

	public static EmailMessageBuilder withSubject(String subject) {
		EmailMessage msg = new EmailMessage();
		msg.setSubject(subject);
		return new EmailMessageBuilder(msg);
	}

	public EmailMessageBuilder withRecipient(String recipient) {
		this.email.setRecipient(recipient);
		return this;
	}

	public EmailMessageBuilder withSender(String sender) {
		this.email.setSender(sender);
		return this;
	}

	public EmailMessageBuilder withContent(String content) {
		this.email.setContent(content);
		return this;
	}

	public EmailMessage build() {
		return this.email;
	}
}

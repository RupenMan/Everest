package edu.mum.everest.email;

import org.springframework.messaging.Message;

/**
 * 
 * @author netra
 */
public interface EmailGateway {
	public void sendEmail(Message<EmailMessage> email);
}
package edu.mum.everest.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 
 * @author netra
 *
 */
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(EmailMessage emailMessage) throws MessagingException {
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		message.setSubject(emailMessage.getSubject());
		message.setTo(emailMessage.getRecipient());

		final String htmlContent = emailMessage.getContent();
		message.setText(htmlContent, true);
		
		this.mailSender.send(mimeMessage);
	}

}

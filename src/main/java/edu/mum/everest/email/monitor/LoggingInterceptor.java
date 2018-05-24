package edu.mum.everest.email.monitor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

/**
 * @author netra
 *
 */
public class LoggingInterceptor extends ChannelInterceptorAdapter {
	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		System.out.println("Message Logged at (" + channel + "): " + message.getPayload().toString());
		return super.preSend(message, channel);
	}
}
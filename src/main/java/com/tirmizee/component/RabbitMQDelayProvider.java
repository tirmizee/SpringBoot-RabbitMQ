package com.tirmizee.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQDelayProvider {

	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void sendDelay(Object message, int milliseconds) {
		rabbitTemplate.convertAndSend("delayed.exchange", "email", message, messagePostProcessor -> {
			messagePostProcessor.getMessageProperties().setDelay(milliseconds);
			return messagePostProcessor;
		});
	}
	
}

package com.tirmizee.component;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQHeaderProducer {

	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void produceMsgToHeader(String msg, String department){
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setHeader("department", department);
		Message message = new Message(msg.getBytes(), messageProperties);
		rabbitTemplate.send("spring.header", null, message);
	}
	
}

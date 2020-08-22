package com.tirmizee.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tirmizee.config.RabbitMQPriorityConfig;

@Component
public class RabbitMQPriorityProducer {

	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void produceMsgToRed(String msg, Integer priority){
		rabbitTemplate.convertAndSend(RabbitMQPriorityConfig.EXCHANGE, RabbitMQPriorityConfig.QUEUE, msg, message -> {
			 message.getMessageProperties().setPriority(priority);
             return message;
		});
	}
	
}

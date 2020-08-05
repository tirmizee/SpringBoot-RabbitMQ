package com.tirmizee.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tirmizee.config.properties.RabbitMQProperty;

@Component
public class RabbitMQDirectProducer {
	
	@Autowired
	private RabbitMQProperty mqProperty;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void produceMsgToRed(String msg){
		for (int i = 0; i < 100000; i++) {
			rabbitTemplate.convertAndSend(mqProperty.getDirectName(), mqProperty.getQueueRed(), msg);
		}
	}

}

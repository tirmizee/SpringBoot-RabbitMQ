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
		rabbitTemplate.convertAndSend(mqProperty.getDirectName(), mqProperty.getQueueRed(), msg);
	}

}

package com.tirmizee.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tirmizee.config.properties.RabbitMQProperty;

@Component
public class RabbitMQDefualtProducer {

	@Autowired
	private RabbitMQProperty mqProperty;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void produceMsgToDefualt(String msg){
		rabbitTemplate.convertAndSend("defualt", msg);
	}
	
}

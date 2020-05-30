package com.tirmizee.component;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class RabbitMQConsumer {
	
	int i = 1;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@RabbitListener(queues="${rabbitmq.queue-name}")
    public void receivedMessage(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		try {
			if (i == 1) {
				channel.basicReject(deliveryTag, true);
				System.out.println("basicReject");
				i++;
			} else {
				System.out.println("Received Message: " + payload);
				rabbitTemplate.convertAndSend("log", payload);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
       
    }
	 
	@RabbitListener(queues="log")
    public void receivedMessage1(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		System.out.println("Received Message log : " + payload);
    }

}

package com.tirmizee.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class RabbitMQDefualtConsumer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQDefualtConsumer.class);
	
	@RabbitListener(queues="defualt")
    public void receivedMessageDefualt(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Defualt Received[{}] Message: {}", deliveryTag , payload);
    }
	
	@RabbitListener(queues="defualt")
    public void receivedMessageDefualt2(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Defualt2 Received[{}] Message: {}", deliveryTag , payload);
    }

}

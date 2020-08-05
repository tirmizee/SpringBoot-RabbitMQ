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
public class RabbitMQDelayConsumer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQDefualtConsumer.class);
	
	@RabbitListener(queues="delay.email")
    public void receivedMessageDelay(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Delay Received[{}] Message: {}",deliveryTag , payload);
    }

}

package com.tirmizee.component;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.tirmizee.config.properties.RabbitMQProperty;

@Component
public class RabbitMQDirectConsumer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQDirectConsumer.class);
	
	private boolean isFirst = true;
	
	@Autowired
	private RabbitMQProperty mqProperty;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@RabbitListener(queues="${rabbitmq.queue-red}")
    public void receivedMessageFromRed(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		try {
			if (isFirst) {
				channel.basicReject(deliveryTag, true);
				LOGGER.info("Queue Red Reject[{}]", deliveryTag);
				isFirst = false;
			} else {
				LOGGER.info("Queue Red Received[{}] Message : {}", deliveryTag, payload);
				rabbitTemplate.convertAndSend(mqProperty.getQueueGreen(), payload);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }
	
	@RabbitListener(queues="${rabbitmq.queue-red}")
    public void receivedMessageFromRed2(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		try {
			if (isFirst) {
				channel.basicReject(deliveryTag, true);
				LOGGER.info("Queue Red Reject[{}]", deliveryTag);
				isFirst = false;
			} else {
				LOGGER.info("Queue Red Received[{}] Message : {}", deliveryTag, payload);
				rabbitTemplate.convertAndSend(mqProperty.getQueueGreen(), payload);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }
	 
	@RabbitListener(queues="${rabbitmq.queue-green}")
    public void receivedMessageGreen(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Green Received[{}] Message: {}",deliveryTag , payload);
    }
	
	@RabbitListener(queues="${rabbitmq.queue-green}")
    public void receivedMessageGreen2(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Green2 Received[{}] Message: {}",deliveryTag , payload);
    }

}

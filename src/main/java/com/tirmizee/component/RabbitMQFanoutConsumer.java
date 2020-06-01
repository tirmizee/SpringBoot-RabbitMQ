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
public class RabbitMQFanoutConsumer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQFanoutConsumer.class);
	
	private boolean isFirst = true;
	
	@Autowired
	private RabbitMQProperty mqProperty;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	@RabbitListener(queues="${rabbitmq.queue-marketing}")
    public void receivedMessageMarketingQueue(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Marketing Received[{}] Message : {}", deliveryTag, payload);
    }
	
	@RabbitListener(queues="${rabbitmq.queue-marketing}")
    public void receivedMessageMarketingQueue2(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Marketing2 Received[{}] Message : {}", deliveryTag, payload);
    }
	 
	@RabbitListener(queues="${rabbitmq.queue-finance}")
    public void receivedMessageFinanceQueue(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Finance Received[{}] Message: {}", deliveryTag , payload);
    }
	
	@RabbitListener(queues="${rabbitmq.queue-finance}")
    public void receivedMessageFinanceQueue2(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag)  {
		LOGGER.info("Queue Finance2 Received[{}] Message: {}", deliveryTag , payload);
    }

}

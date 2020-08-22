package com.tirmizee.component;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.tirmizee.config.RabbitMQPriorityConfig;

@Component
public class RabbitMQPriorityConsumer {

public static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQPriorityConsumer.class);
	
	@RabbitListener(queues = RabbitMQPriorityConfig.QUEUE, priority = "9")
    public void receivedMessageDelay(
    		@Payload String payload, 
    		@Header(AmqpHeaders.CHANNEL) Channel channel, 
    		@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag,
    		@Header("priority") Integer priority) throws InterruptedException, IOException {
//		com.rabbitmq.client.AMQP.BasicProperties
//		org.springframework.messaging.handler.annotation.
		Thread.sleep(1000);
		LOGGER.info("Queue[{}] Priority Received[{}] priority[{}] Message: {}",Thread.currentThread().getId(), deliveryTag, priority, payload);
    }
	
}

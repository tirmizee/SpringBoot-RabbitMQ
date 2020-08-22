package com.tirmizee.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.config.properties.RabbitMQProperty;

@Configuration
public class RabbitMQDirectConfig {

	@Autowired
	private RabbitMQProperty mqProperty;
	
	@Bean
	public Queue queueRed() {
		return new Queue(mqProperty.getQueueRed(), false);
	}
	
	@Bean
	public Queue queueGreen() {
		return new Queue(mqProperty.getQueueGreen(), false);
	}
	
	@Bean
	public DirectExchange directExchange() {
        return new DirectExchange(mqProperty.getDirectName());
    }
	
	@Bean
	public Binding binding1(DirectExchange directExchange, Queue queueRed) {
		return BindingBuilder.bind(queueRed).to(directExchange).withQueueName();
	}
	
	@Bean
	public Binding binding2(DirectExchange directExchange, Queue queueGreen) {
		return BindingBuilder.bind(queueGreen).to(directExchange).withQueueName();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		return new RabbitTemplate(connectionFactory);
	}
	
}

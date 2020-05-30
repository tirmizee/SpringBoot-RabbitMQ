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
public class RabbitMQConfig {

	@Autowired
	private RabbitMQProperty mqProperty;
	
	@Bean
	public Queue queue() {
		return new Queue(mqProperty.getQueueName(), false);
	}
	
//	@Bean
//    TopicExchange exchange() {
//		 return new TopicExchange(mqProperty.getExchangeName());
//    }
	
	@Bean
    DirectExchange exchange() {
        return new DirectExchange(mqProperty.getExchangeName());
    }
	
	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(mqProperty.getRoutingKey());
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		return new RabbitTemplate(connectionFactory);
	}
	
}

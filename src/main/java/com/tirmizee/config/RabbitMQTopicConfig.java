package com.tirmizee.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.config.properties.RabbitMQProperty;

@Configuration
public class RabbitMQTopicConfig {
	
	@Autowired
	private RabbitMQProperty mqProperty;
	
	@Bean
	public Queue allQueue() {
		return new Queue(mqProperty.getQueueAll(), false);
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(mqProperty.getTopicName());
	}
	
	@Bean
	public Binding marketingBindingTopic(Queue marketingQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(marketingQueue).to(topicExchange).with("queue.marketing");
	}
	
	@Bean
	public Binding financeBindingTopic(Queue financeQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(financeQueue).to(topicExchange).with("queue.finance");
	}
	
	@Bean
	public Binding allBindingTopic(Queue allQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
	}

}

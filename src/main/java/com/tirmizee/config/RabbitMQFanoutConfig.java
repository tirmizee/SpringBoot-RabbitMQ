package com.tirmizee.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.config.properties.RabbitMQProperty;

@Configuration
public class RabbitMQFanoutConfig {
	
	@Autowired
	private RabbitMQProperty mqProperty;
	
	@Bean
	public Queue marketingQueue() {
		return new Queue(mqProperty.getQueueMarketing(), false);
	}

	@Bean
	public Queue financeQueue() {
		return new Queue(mqProperty.getQueueFinance(), false);
	}
	
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(mqProperty.getFanoutName());
	}
	
	@Bean
	public Binding marketingBinding(Queue marketingQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(marketingQueue).to(fanoutExchange);
	}

	@Bean
	public Binding financeBinding(Queue financeQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(financeQueue).to(fanoutExchange);
	}

}

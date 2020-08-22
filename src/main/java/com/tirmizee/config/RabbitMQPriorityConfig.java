package com.tirmizee.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQPriorityConfig {

	public static final String EXCHANGE = "priority-direct-exchange";
	
	public static final String QUEUE = "priority-queue";
	
	@Bean
	public Queue priorityQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-max-priority", 10);
        return new Queue(QUEUE, true, false, false, args);
    }
	
	@Bean
	public DirectExchange priorityDirectExchange() {
        return new DirectExchange(EXCHANGE);
    }
	
	@Bean
	public Binding bindingPriorityQueue(Queue priorityQueue, DirectExchange priorityDirectExchange) {
        return BindingBuilder.bind(priorityQueue).to(priorityDirectExchange).with(QUEUE);
    }
	
}

package com.tirmizee.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDelayedConfig {
	
	@Bean
	public Queue delayEmail() {
		return new Queue("delay.email", false);
	}
	
	@Bean
	public CustomExchange delayExchange() {
	    Map<String, Object> args = new HashMap<String, Object>();
	    args.put("x-delayed-type", "direct");
	    return new CustomExchange("delayed.exchange", "x-delayed-message", true, false, args);
	}

    @Bean
    public Binding bindingEmailThrottlingCentral(Queue delayEmail, Exchange delayExchange) {
        return BindingBuilder.bind(delayEmail).to(delayExchange).with("email").noargs();
    }
	
}

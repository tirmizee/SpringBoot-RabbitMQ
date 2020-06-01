package com.tirmizee.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDefualtConfig {
	
	@Bean
	public Queue queueDefualt() {
		return new Queue("defualt", false);
	}

}

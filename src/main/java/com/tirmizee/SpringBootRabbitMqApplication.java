package com.tirmizee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.tirmizee.config.properties.RabbitMQProperty;

@SpringBootApplication
@EnableConfigurationProperties({RabbitMQProperty.class})
public class SpringBootRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitMqApplication.class, args);
	}

}

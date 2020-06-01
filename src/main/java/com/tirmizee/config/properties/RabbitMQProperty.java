package com.tirmizee.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("rabbitmq")
public class RabbitMQProperty {
	
	private String directName;
	private String queueRed;
	private String queueGreen;
	
	private String fanoutName;
	private String queueMarketing;
	private String queueFinance;
	
	private String topicName;
	private String queueAll;

}

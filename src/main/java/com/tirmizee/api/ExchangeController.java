package com.tirmizee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.component.RabbitMQDefualtProducer;
import com.tirmizee.component.RabbitMQDelayProvider;
import com.tirmizee.component.RabbitMQDirectProducer;
import com.tirmizee.component.RabbitMQFanoutProducer;
import com.tirmizee.component.RabbitMQHeaderProducer;

@RestController
@RequestMapping(path = "/exchange")
public class ExchangeController {

	@Autowired
	private RabbitMQDelayProvider rabbitMQDelayProvider;
	
	@Autowired
	private RabbitMQDirectProducer rabbitMQProducer;
	
	@Autowired
	private RabbitMQFanoutProducer rabbitMQFanoutProducer;
	
	@Autowired
	private RabbitMQDefualtProducer rabbitMQDefualtProducer;
	
	@Autowired
	private RabbitMQHeaderProducer RabbitMQHeaderProducer;
	
	@GetMapping(path = "/direct/{msg}")
	public String directHello(@PathVariable String msg) {
		rabbitMQProducer.produceMsgToRed(msg);
		return "success";
	}
	
	@GetMapping(path = "/fanout/{msg}")
	public String fanoutHello(@PathVariable String msg) {
		rabbitMQFanoutProducer.produceMsgToFanout(msg);
		return "success";
	}
	
	@GetMapping(path = "/defualt/{msg}")
	public String defualtHello(@PathVariable String msg) {
		rabbitMQDefualtProducer.produceMsgToDefualt(msg);
		return "success";
	}
	
	@GetMapping(path = "/header/{msg}/{department}")
	public String defualtHello(@PathVariable String msg, @PathVariable String department) {
		RabbitMQHeaderProducer.produceMsgToHeader(msg, department);
		return "success";
	}
	
	@GetMapping(path = "/delay/{msg}")
	public String delayed(@PathVariable String msg) {
		rabbitMQDelayProvider.sendDelay(msg, 5000);
		return "success";
	}
	
}

package com.tirmizee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.component.RabbitMQProducer;

@RestController
@RequestMapping(path = "/exchange")
public class ExchangeController {

	@Autowired
	private RabbitMQProducer rabbitMQProducer;
	
	@GetMapping(path = "/{msg}")
	public String hello(@PathVariable String msg) {
		rabbitMQProducer.produceMsg(msg);
		return "success";
	}
	
	
}

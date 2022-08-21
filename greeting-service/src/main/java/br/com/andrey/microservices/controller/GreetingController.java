package br.com.andrey.microservices.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrey.microservices.Greeting;
import br.com.andrey.microservices.configuration.GreetingConfiguration;

@RestController
public class GreetingController {

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingConfiguration config;
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
		if (name.isEmpty()) {
			name = config.getDefaultValue();
		}
		
		return new Greeting(counter.incrementAndGet(), String.format(template, config.getGreeting(), name));
	}
}

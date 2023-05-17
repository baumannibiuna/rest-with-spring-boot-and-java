package com.baumannibiuna.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//Classe responsavel por disponibilizar o end point para a aplicaçao
@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//Annotation responsavel por mapear o recurso a ser usado
	@RequestMapping("/greeting")
	//Metodo que permite retornar um valor requisitado pela url, no caso a variavel name
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") 
	String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}

package org.consumer.discovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private EurekaClient discoveryClient;
	
	@HystrixCommand(fallbackMethod = "buyTicketFallback")
	@GetMapping("/buyTicket")
	public String buyTicket() {
		//InstanceInfo instance = discoveryClient.getNextServerFromEureka("eureka-service", false);
		//String aa = instance.getHomePageUrl()+" : "+instance.getPort();
		String ticket = restTemplate.getForObject("http://eureka-service/{1}", String.class,"ticket");
		return "ribbon consumer request : " + ticket;
	}
	private String buyTicketFallback() {
		return "ribbon consumer request : failed , this response from the fallback of circuit breakers.";
	}
}

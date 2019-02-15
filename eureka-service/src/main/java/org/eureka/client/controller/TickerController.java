package org.eureka.client.controller;

import org.eureka.client.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TickerController {
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/ticket")
	public String getTicket() {
		return ticketService.getTicket();
	}
}

package org.consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FeginController {
	@Autowired
	private ServiveClient serviveClient;
	
	@GetMapping("/buyTicket")
	public String buyTicket() {
		return "consumer-feign request: " + serviveClient.getTicket();
	}

}

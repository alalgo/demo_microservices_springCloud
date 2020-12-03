package org.alalgo.osc.web;

import org.alalgo.usc.api.service.SecurityServiceApi;
import org.alalgo.usc.dos.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private SecurityServiceApi securityServiceApi;
	
	@GetMapping("/getOrderOwn")
	public UserDO getOrderOwn(String username) {
		return securityServiceApi.getUser(username);
	}
	
	@GetMapping("/get")
	public String getOrderOwn() {
		return "hello you get it ";
	}

}

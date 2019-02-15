package org.eureka.client.service.impl;

import org.eureka.client.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private EurekaClient discoveryClient;
	@Override
	public String getTicket() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("EUREKA-SERVICE", false);
		return "service-"+instance.getAppName()+"   port-" + instance.getPort();
	}

}

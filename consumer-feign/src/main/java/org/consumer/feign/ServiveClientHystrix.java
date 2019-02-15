package org.consumer.feign;

import org.springframework.stereotype.Component;

@Component
public class ServiveClientHystrix implements ServiveClient{

	@Override
	public String getTicket() {
		return "failed , this response from the fallback of circuit breakers.";
	}

}

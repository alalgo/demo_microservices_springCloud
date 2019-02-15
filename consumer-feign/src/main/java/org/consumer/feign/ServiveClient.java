package org.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
@Component
@FeignClient(value = "eureka-service",fallback = ServiveClientHystrix.class)
public interface ServiveClient {
	@GetMapping("/ticket")
	String getTicket();
}

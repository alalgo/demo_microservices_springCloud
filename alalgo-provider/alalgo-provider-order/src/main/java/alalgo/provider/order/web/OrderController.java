package alalgo.provider.order.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@RequestMapping("/test")
	public String test() {
		return "this is order controller";
	}

}

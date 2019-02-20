package org.alalgo.zipkinclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinclientController {
	
	@GetMapping
	public String sayhello() {
		return "hi ,i'm from zipkin client";
	}
}

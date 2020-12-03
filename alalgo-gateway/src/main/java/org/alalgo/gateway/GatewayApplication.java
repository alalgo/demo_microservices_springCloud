package org.alalgo.gateway;

import org.alalgo.gateway.conf.zuul.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication 
{	
    public static void main( String[] args )
    {
    	
    	SpringApplication.run(GatewayApplication.class, args);
    	
    }
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}    
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}

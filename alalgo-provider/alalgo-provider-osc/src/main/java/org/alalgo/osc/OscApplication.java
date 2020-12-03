package org.alalgo.osc;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages= {"org.alalgo.usc.api.hystrix","org.alalgo.osc"})
public class OscApplication extends  SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(OscApplication.class, args);
    }
}
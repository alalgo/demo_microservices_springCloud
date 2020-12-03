package org.alalgo.usc;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
//@EnableCircuitBreaker
public class UscApplication extends  SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(UscApplication.class, args);
    }
}
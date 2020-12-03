package org.alalgo.Authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class AuthserverApplication extends  SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(AuthserverApplication.class, args);
    }
}
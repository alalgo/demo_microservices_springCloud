package org.alalgo.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
@zipkin2.server.internal.EnableZipkinServer
public class App extends  SpringBootServletInitializer
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}

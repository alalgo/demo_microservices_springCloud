package org.alalgo.bpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {   
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        })
public class BpmApplication {

public static void main(String[] args) throws Exception {
	SpringApplication.run(BpmApplication.class, args);
}
}

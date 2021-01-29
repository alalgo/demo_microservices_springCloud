package org.alalgo.usc.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MQConf {
	
    @Bean
    public Queue queue() {
         return new Queue("registMsgQueue");
    }
    
}
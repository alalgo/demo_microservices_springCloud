package org.alalgo.usc.mqconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Comsumer {
    @RabbitListener(queues="registMsgQueue") 
    public void processC(String str) {
        log.debug("rabbitmq send msg:"+str);
    }
}

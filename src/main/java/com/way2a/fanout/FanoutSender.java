package com.way2a.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 11431 on 2018/4/15.
 */

@Component
public class FanoutSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String msg = "fanoutSender: hello fanout";
        System.out.println("fanoutSender : " + msg);
        rabbitTemplate.convertAndSend("fanoutExchange","aaa",msg);
    }
}

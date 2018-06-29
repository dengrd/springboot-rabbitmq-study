package com.way2a.hello;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by 11431 on 2018/4/15.
 */

@Component
public class HelloSenderB {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String msg = "helloB " + new Date();
        System.out.println("HelloSendB: " + msg);
        rabbitTemplate.convertAndSend("hello",msg);
    }

    public void send(String msg){
        msg += new Date();
        System.out.println("HelloSendB: " + msg);
        rabbitTemplate.convertAndSend("hello",msg);
    }
}

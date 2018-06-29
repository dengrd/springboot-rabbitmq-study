package com.way2a.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 11431 on 2018/4/15.
 */

@Component
@RabbitListener(queues = "hello")
public class HelloReceiverA {

    @RabbitHandler
    public void proccess(String msg){
        System.out.println("HelloReceiverA: " + msg);
    }
}

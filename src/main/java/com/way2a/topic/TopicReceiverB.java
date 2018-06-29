package com.way2a.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 11431 on 2018/4/15.
 */

@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiverB {

    @RabbitHandler
    public void process(String msg){
        System.out.println("TopicReceiverB : " + msg);
    }

}

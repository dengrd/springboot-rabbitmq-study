package com.way2a.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 11431 on 2018/4/15.
 */

@Component
public class TopicSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String msg1 = "i am topic.message msg***************";
        System.out.println("sender1 : " + msg1);
        rabbitTemplate.convertAndSend("topicExchange","topic.messageKey",msg1);

        String msg2 = "i am topic.messages msg ##############";
        System.out.println("sender2 : " + msg2);
        rabbitTemplate.convertAndSend("topicExchange","topic.test",msg2);
    }

}

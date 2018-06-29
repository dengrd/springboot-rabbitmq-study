package com.way2a.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * Created by 11431 on 2018/4/15.
 */

@Component
public class CallbackSender implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
    }
    public void send(){
        String msg = "callbacksender : i am a callback sender";
        System.out.println(msg);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("callbackSender UUID : " + correlationData.getId());
        rabbitTemplate.convertAndSend("topicExchange","topic.messages",msg,correlationData);
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("callback confirm : " + correlationData.getId());
    }
}

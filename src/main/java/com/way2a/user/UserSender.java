package com.way2a.user;

import com.way2a.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 11431 on 2018/4/15.
 */

@Component
public class UserSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        User user = new User();
        user.setName("tom");
        user.setPassword("12345");
        System.out.println("UserSender: "+ user.getName()+"<>"+user.getPassword());
        rabbitTemplate.convertAndSend("user",user);
    }
}

package com.way2a.user;

import com.way2a.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 11431 on 2018/4/15.
 */

@Component
@RabbitListener(queues = "user")
public class UserReceiver {

    @RabbitHandler
    public void process(User user){
        System.out.println("UserReceiver: "+ user.getName()+"<>"+user.getPassword());
    }
}

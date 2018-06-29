package com.way2a.controller;

import com.way2a.callback.CallbackSender;
import com.way2a.fanout.FanoutSender;
import com.way2a.hello.HelloSenderA;
import com.way2a.hello.HelloSenderB;
import com.way2a.topic.TopicSender;
import com.way2a.user.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 11431 on 2018/4/15.
 */

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSenderA helloSenderA;

    @Autowired
    private HelloSenderB helloSenderB;

    @Autowired
    private UserSender userSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private CallbackSender callbackSender;


    @PostMapping
    public void hello(){
        helloSenderA.send();
    }

    /**
     * 单生产者，多消费者,   从控制台结果中可知一个消息只能被其中某一个消费者接收，其他的消费者接收不到这个消息
     */
    @PostMapping("oneToMany")
    public void oneToMany(){
        for (int i=0;i<5;i++){
            helloSenderA.send("*****helloMsg:"+i+"--->");
        }
    }

    /**
     * 多生产者，多消费者，  和一对多一样，消息被消费者均匀接收，一个消息只能被消费一次
     */
    @PostMapping("manyToMany")
    public void manyToMany(){
        for (int i=0;i<5;i++){
            helloSenderA.send("*****A发送的:"+i+"--->");
            helloSenderB.send("*****B发送的:"+i+"--->");
        }
    }

    /**
     * 测试生产者发送实体类消息
     */
    @PostMapping("/user")
    public void userTest(){
        userSender.send();
    }

    /**
     * 测试topic类型的exchange
     */
    @PostMapping("/topicTest")
    public void topicTest(){
        topicSender.send();
    }

    /**
     * 测试fanout广播模式交换器
     */
    @PostMapping("/fanoutTest")
    public void fanoutTest(){
        fanoutSender.send();
    }

    /**
     * 测试回调
     */
    @PostMapping("/callback")
    public void callBackTest(){
        callbackSender.send();
    }
}

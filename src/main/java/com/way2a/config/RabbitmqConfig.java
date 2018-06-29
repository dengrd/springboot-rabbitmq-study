package com.way2a.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by 11431 on 2018/4/15.
 */

@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }

    @Bean
    public Queue userQueue(){
        return new Queue("user");
    }

    //============= topic Exchange 的队列
    @Bean
    public Queue queueMessage(){
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }
    //======================================

    //=============== fanout Exchange 的队列
    @Bean
    public Queue aMessage(){
        return new Queue("fanout.A");
    }
    @Bean
    public Queue bMessage(){
        return new Queue("fanout.B");
    }
    @Bean
    public Queue cMessage(){
        return new Queue("fanout.C");
    }
    //=========================================

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将队列topic.message与topicExchange绑定，binding_key为topic.message，就是完全匹配
     * @param queueMessage
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage,TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.messageKey");
    }

    /**
     * 将队列topic.messages与topicExchange绑定，binding_key为topic.#，模糊匹配
     * @param queueMessages
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages,TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
    }

    @Bean
    public Binding bindingExchangeA(Queue aMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(aMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(Queue bMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(bMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeC(Queue cMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(cMessage).to(fanoutExchange);
    }

}

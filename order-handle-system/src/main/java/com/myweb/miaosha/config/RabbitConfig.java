package com.myweb.miaosha.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    public static final String ORDER_QUEUE = "order";
    public static final String TOPIC_EXCHANGE = "topicExchage";

    @Bean
    public Queue queue(){
        return new Queue(ORDER_QUEUE);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeMsg(){
        return BindingBuilder.bind(queue()).to(exchange()).with(ORDER_QUEUE);
    }
}

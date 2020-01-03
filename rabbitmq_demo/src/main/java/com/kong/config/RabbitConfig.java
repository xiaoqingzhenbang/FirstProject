package com.kong.config;/**
 * Created by xuebi on 2020/1/2.
 */

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitConfig
 * @Description 交换器与队列的配置类
 * @Author kongdeqi
 * @Date 2020/1/2 10:49
 * @Version 1.0
 */

@Configuration
public class RabbitConfig {

    //定义交换器
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange",false,false);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange",false,false);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange",false,false);
    }

    //定义队列
    @Bean
    public Queue firstQueue(){
        return new Queue("firstQueue",false,false,false,null);
    }

    @Bean
    public Queue secondQueue(){
        return new Queue("secondQueue",false,false,false,null);
    }

    @Bean
    public Queue threeQueue(){
        return new Queue("threeQueue",false,false,false,null);
    }

    @Bean
    public Queue fourQueue(){
        return new Queue("fourQueue",false,false,false,null);
    }

    @Bean
    public Queue fiveQueue(){
        return new Queue("fiveQueue",false,false,false,null);
    }


    //定义队列与交换机的对应关系
    @Bean
    public Binding bindingFirst(@Qualifier("firstQueue") Queue queue,
                                @Qualifier("directExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("xiaokong.com");
    }

    @Bean
    public Binding bindingSecond(@Qualifier("secondQueue") Queue queue,
                                 @Qualifier("topicExchange") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("*.xiaokong.cn.*");
    }

    @Bean
    public Binding bindingFive(@Qualifier("fiveQueue") Queue queue,
                                 @Qualifier("topicExchange") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("*.xiaokong.cn.*");
    }

    @Bean
    public Binding bindingThree(@Qualifier("threeQueue") Queue queue,
                                 @Qualifier("fanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFour(@Qualifier("fourQueue") Queue queue,
                                @Qualifier("fanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}

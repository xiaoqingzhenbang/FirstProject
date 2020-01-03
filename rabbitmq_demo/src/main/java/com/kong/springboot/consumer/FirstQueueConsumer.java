package com.kong.springboot.consumer;/**
 * Created by xuebi on 2020/1/2.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName Consumer
 * @Description 消费端
 * @Author kongdeqi
 * @Date 2020/1/2 12:05
 * @Version 1.0
 */

@Component
@RabbitListener(queues = "firstQueue")
public class FirstQueueConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("接收firstQueue消息= "+msg);
    }
}

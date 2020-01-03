package com.kong.springboot.consumer;/**
 * Created by xuebi on 2020/1/2.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FiveQueueConsumer
 * @Description TODO
 * @Author kongdeqi
 * @Date 2020/1/2 14:24
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "fiveQueue")
public class FiveQueueConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("接收fiveQueue消息= "+msg);
    }
}

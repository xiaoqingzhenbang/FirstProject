package com.kong.springboot.consumer;/**
 * Created by xuebi on 2020/1/2.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName SecondQueueConsumer
 * @Description TODO
 * @Author kongdeqi
 * @Date 2020/1/2 13:39
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "secondQueue")
public class SecondQueueConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("接收secondQueue消息= "+msg);
    }
}

package com.kong.springboot.consumer;/**
 * Created by xuebi on 2020/1/2.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FourQueueConsumer
 * @Description TODO
 * @Author kongdeqi
 * @Date 2020/1/2 13:44
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "fourQueue")
public class FourQueueConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("接收fourQueue消息= "+msg);
    }
}

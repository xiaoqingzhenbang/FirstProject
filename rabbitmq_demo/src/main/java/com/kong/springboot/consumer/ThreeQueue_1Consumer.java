package com.kong.springboot.consumer;/**
 * Created by xuebi on 2020/1/2.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName ThreeQueue_1Consumer
 * @Description TODO
 * @Author kongdeqi
 * @Date 2020/1/2 14:30
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "threeQueue")
public class ThreeQueue_1Consumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("接收threeQueue_1消息= "+msg);
    }
}

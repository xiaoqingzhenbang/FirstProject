package com.kong.springboot.consumer;/**
 * Created by xuebi on 2020/1/2.
 */

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName CommonQueueConsumer
 * @Description TODO
 * @Author kongdeqi
 * @Date 2020/1/2 14:39
 * @Version 1.0
 */
@Component
public class CommonQueueConsumer {

    @RabbitListener(queues = "firstQueue")
    public void firstQueueConsumer(Message message, Channel channel) throws IOException {
        System.out.println(new String(message.getBody(),"UTF-8"));
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        System.out.println();
    }
}

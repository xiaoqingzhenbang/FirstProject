package com.kong.springboot.producer;/**
 * Created by xuebi on 2020/1/2.
 */

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Producer
 * @Description 生产者端
 * @Author kongdeqi
 * @Date 2020/1/2 12:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sendMsg")
    public void sendMsg(){

        rabbitTemplate.convertAndSend("directExchange","xiaokong.com","directExchange");

        rabbitTemplate.convertAndSend("topicExchange","a.xiaokong.cn.b","topicExchange");

        rabbitTemplate.convertAndSend("fanoutExchange","","fanoutExchange");
    }
}

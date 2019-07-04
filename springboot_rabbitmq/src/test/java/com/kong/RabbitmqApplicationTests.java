package com.kong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        Map message = new HashMap<>();
        message.put("data", "你好");
        message.put("message", "不好");
//		1.单播
        rabbitTemplate.convertAndSend("kong.direct", "kong.direct", message);
    }


    @Test
    public void receive() {
        Map dircet = (Map) rabbitTemplate.receiveAndConvert("kong.queue.direct");
        System.out.println(dircet);
    }

}

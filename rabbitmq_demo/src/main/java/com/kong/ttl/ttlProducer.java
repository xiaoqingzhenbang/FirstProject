package com.kong.ttl;/**
 * Created by xuebi on 2019/12/30.
 */

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ttlProducer
 * @Description 设置过期型生产者
 * @Author kongdeqi
 * @Date 2019/12/30 17:00
 * @Version 1.0
 */
public class ttlProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //配置工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("/");
        factory.setHost("47.93.245.225");
        factory.setPort(5672);
        //获取连接
        Connection connection = factory.newConnection();
        //创建消息通道
        Channel channel = connection.createChannel();
        //消息
        String msg = "Hello World,Rabbit MQ";

        //对队列设置过期时间
//        Map params = new HashMap();
//        params.put("x-message-ttl",6000);
        //声明队列
//        channel.queueDeclare("TEST_TTL_QUEUE",false,false,false,params);

        //对每条消息设置过期
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .deliveryMode(2)//持久化消息
                .contentEncoding("UTF-8")
                .expiration("10000")//TTL过期时间
                .build();

        //两种方式如果同时设置，以最小的过期时间为准
        //发送消息
        channel.basicPublish("","TTL_QUEUE",properties,msg.getBytes());
        //关闭流
        channel.close();
        connection.close();
    }
}

package com.kong.ttl;/**
 * Created by xuebi on 2019/12/31.
 */

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ttlConsumer
 * @Description 设置过期型消费者
 * @Author kongdeqi
 * @Date 2019/12/31 11:00
 * @Version 1.0
 */
public class ttlConsumer {

    public static String TTL_QUEUE = "TTL_QUEUE";

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
        //对队列设置过期时间
        Map params = new HashMap();
        params.put("x-message-ttl",6000);
        //创建队列
        channel.queueDeclare(TTL_QUEUE,false,false,false,params);
        //消费者
        Consumer consumer = new Consumer() {
            @Override
            public void handleConsumeOk(String s) {

            }

            @Override
            public void handleCancelOk(String s) {

            }

            @Override
            public void handleCancel(String s) throws IOException {

            }

            @Override
            public void handleShutdownSignal(String s, ShutdownSignalException e) {

            }

            @Override
            public void handleRecoverOk(String s) {

            }

            @Override
            public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
                System.out.println("收到延时消息===="+new String(bytes,"UTF-8"));
            }
        };
        //接收消息
        channel.basicConsume(TTL_QUEUE,consumer);
    }
}

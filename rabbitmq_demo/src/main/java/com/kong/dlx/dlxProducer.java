package com.kong.dlx;/**
 * Created by xuebi on 2019/12/31.
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName dlxProducer
 * @Description 死信队列生产者
 * @Author kongdeqi
 * @Date 2019/12/31 11:19
 * @Version 1.0
 */
public class dlxProducer {

    public static String EXCHANGE_NAME = "COMMON_EXCHANGE";

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
        //发布消息
        channel.basicPublish(EXCHANGE_NAME,"COMMON_ROUTE",null,msg.getBytes());
        //关闭流
        channel.close();
        connection.close();
    }
}

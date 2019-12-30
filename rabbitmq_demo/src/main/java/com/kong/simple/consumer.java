package com.kong.simple;/**
 * Created by xuebi on 2019/12/30.
 */

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName consumer
 * @Description TODO
 * @Author kongdeqi
 * @Date 2019/12/30 15:39
 * @Version 1.0
 */
public class consumer {

    public static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    public static String QUEUE_NAME = "SIMPLE_QUEUE";

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
        //声明交换机
        //参数一:交换机名称
        //参数二:交换机类型
        //参数三:是否持久化（重启服务器消失）
        //参数四:交换机是否删除（不再被使用）
        //参数五:附加属性
        channel.exchangeDeclare(EXCHANGE_NAME,"direct",false,false,null);
        //声明队列
        //参数一:队列名称
        //参数二:是否持久化
        //参数三:是否只对当前connection可见
        //参数四:所有客户端都断开连接是否删除
        //参数五:附加属性
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        System.out.println("Waiting for Message ....");
        //绑定队列和交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"gupao.best");
        //创建消费者
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
                String msg = new String(bytes,"UTF-8");
                System.out.println("received message" + msg);
                System.out.println(s);
            }
        };
        //开始获取消息
        channel.basicConsume(QUEUE_NAME,true,consumer);
        //关闭流
//        channel.close();
//        connection.close();
    }
}

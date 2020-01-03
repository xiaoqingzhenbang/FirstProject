package com.kong.dlx;/**
 * Created by xuebi on 2019/12/31.
 */

import com.rabbitmq.client.*;
import sun.security.krb5.internal.PAData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName dlxConsumer
 * @Description 死信队列消费者
 * @Author kongdeqi
 * @Date 2019/12/31 11:19
 * @Version 1.0
 */
public class dlxConsumer {

    /**
     * 死信队列情况
     * 1.消息过期
     * 2.消费端reject 或 消费端返回nack并且queue == false拒绝重新入队
     * 3.队列达到最大长度，最先入队的消息会到死信队列
     */
    //普通交换机名字
    public static String COMMON_EXCHANGE = "COMMON_EXCHANGE";
    //普通队列名字
    public static String COMMON_QUEUE = "COMMON_QUEUE";
    //绑定普通交换机与普通队列路由
    public static String COMMON_ROUTE = "COMMON_ROUTE";

    //死信交换机名字
    public static String DEAD_EXCHANGE = "DEAD_EXCHANGE";
    //死信队列名字
    public static String DEAD_QUEUE = "DEAD_QUEUE";

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

        //创建普通交换机
        channel.exchangeDeclare(COMMON_EXCHANGE,"direct",false,false,null);
        //创建普通队列
        //绑定到死信队列
        Map params = new HashMap();
        params.put("x-dead-letter-exchange",DEAD_EXCHANGE);
        params.put("x-dead-letter-routing-key",COMMON_ROUTE);
        params.put("x-message-ttl",6000);
        channel.queueDeclare(COMMON_QUEUE,false,false,false, params);
        //绑定普通交换机与普通队列路由
        channel.queueBind(COMMON_QUEUE,COMMON_EXCHANGE,COMMON_ROUTE);

        //创建死信交换机
        channel.exchangeDeclare(DEAD_EXCHANGE,"direct",false,false,null);
        //创建死信队列
        channel.queueDeclare(DEAD_QUEUE,false,false,false, null);
        //绑定死信交换机与死信队列路由
        channel.queueBind(DEAD_QUEUE,DEAD_EXCHANGE,COMMON_ROUTE);

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
                System.out.println("发送过来的消息====="+new String(bytes,"UTF-8"));
                //拒绝消息并且不允许从新入队
//                channel.basicReject(envelope.getDeliveryTag(),false);
                //返回nack并且不允许从新入队
                //第二个参数: 是否批量.true:将一次性拒绝所有小于deliveryTag的消息
                channel.basicNack(envelope.getDeliveryTag(),true,false);
            }
        };

        //消息过期
        //第二个参数：是否自动应答
//        channel.basicConsume(DEAD_QUEUE,true,consumer);
        //消费端reject
        channel.basicConsume(COMMON_QUEUE,false,consumer);
    }
}

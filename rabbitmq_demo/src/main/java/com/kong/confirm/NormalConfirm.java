package com.kong.confirm;/**
 * Created by xuebi on 2020/1/3.
 */

import com.kong.Utils.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName NormalConfirm
 * @Description 普通发送方确认模式（单条确认）
 * @Author kongdeqi
 * @Date 2020/1/3 14:33
 * @Version 1.0
 */
public class NormalConfirm {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        String msg = "normalConfirm send message!";
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel();
        channel.queueDeclare("normalConfirm",false,false,false,null);

        channel.confirmSelect();
        channel.basicPublish("","normalConfirm", null,msg.getBytes("UTF-8"));
        channel.waitForConfirms();
        System.out.println("消息发送成功！");
    }
}

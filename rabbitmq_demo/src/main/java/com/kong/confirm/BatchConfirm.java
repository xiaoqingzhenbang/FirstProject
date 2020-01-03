package com.kong.confirm;/**
 * Created by xuebi on 2020/1/3.
 */

import com.kong.Utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName BatchConfirm
 * @Description 批量确认模式
 * @Author kongdeqi
 * @Date 2020/1/3 14:34
 * @Version 1.0
 */
public class BatchConfirm {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        String msg = "batchConfirm send message!";
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel();
        channel.queueDeclare("batchConfirm",false,false,false,null);

        channel.confirmSelect();
        for (int i=0;i<=20;i++){
            channel.basicPublish("","batchConfirm", null,msg.getBytes("UTF-8"));
        }
        channel.waitForConfirmsOrDie();
        System.out.println("消息发送成功！");
    }
}

package com.kong.confirm;/**
 * Created by xuebi on 2020/1/3.
 */

import com.kong.Utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName AsynConfirm
 * @Description 异步Confirm模式
 * @Author kongdeqi
 * @Date 2020/1/3 14:34
 * @Version 1.0
 */
public class AsynConfirm {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        String msg = "asynConfirm send message!";
        Connection conn = ConnectionUtil.getConnection();
        Channel channel = conn.createChannel();
        channel.queueDeclare("asynConfirm",false,false,false,null);

        channel.confirmSelect();
        for (int i=0;i<=20;i++){
            channel.basicPublish("","asynConfirm", null,msg.getBytes("UTF-8"));
        }
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.out.println("接收响应成功消息tag="+l+";是否批量="+b);
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.out.println("接收响应失败消息tag="+l+";是否批量="+b);
            }
        });
    }
}

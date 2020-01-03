package com.kong.transaction;/**
 * Created by xuebi on 2020/1/2.
 */

import com.kong.Utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName TraProducer
 * @Description transaction事务
 * @Author kongdeqi
 * @Date 2020/1/2 15:05
 * @Version 1.0
 */
public class TraProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        String msg = "transaction send msg!";
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("transactionQueue",false,false,false,null);

        try {
            channel.txSelect();
            channel.basicPublish("","transactionQueue",null,msg.getBytes());
            channel.txCommit();
            System.out.println("发送消息到服务器成功!");
        } catch (IOException e) {
            e.printStackTrace();
            channel.txRollback();
        }finally {
            channel.close();
            connection.close();
        }

    }
}

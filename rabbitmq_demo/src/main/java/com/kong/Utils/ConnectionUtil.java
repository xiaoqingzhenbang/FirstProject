package com.kong.Utils;/**
 * Created by xuebi on 2020/1/2.
 */

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ConnectionUtil
 * @Description TODO
 * @Author kongdeqi
 * @Date 2020/1/2 15:10
 * @Version 1.0
 */
public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory =new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("47.93.245.225");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        return connection;
    }
}

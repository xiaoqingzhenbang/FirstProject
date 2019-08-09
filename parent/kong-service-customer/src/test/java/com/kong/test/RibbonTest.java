package com.kong.test;/**
 * Created by xuebi on 2019/8/2.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName RibbonTest
 * @Description TODO
 * @Author xuebi
 * @Date 2019/8/2 15:48
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RibbonTest {

    @Autowired
    private RibbonLoadBalancerClient client;

    @Test
    public void ribbonTest(){
        for (int i=0;i<50;i++){
            ServiceInstance service = client.choose("kong-service-privoder");
            String host = service.getHost();
            int port = service.getPort();
            System.out.println(host+port);
        }
    }
}

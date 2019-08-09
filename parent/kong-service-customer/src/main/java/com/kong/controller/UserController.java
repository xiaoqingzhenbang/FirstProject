package com.kong.controller;/**
 * Created by xuebi on 2019/7/31.
 */

import com.kong.client.UserClient;
import com.kong.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author xuebi
 * @Date 2019/7/31 15:40
 * @Version 1.0
 */

@Controller
@RequestMapping(value = "/user")
//@DefaultProperties(defaultFallback = "queryUserByIdFailBakDefault")
public class UserController {

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET)
    @ResponseBody
//    @HystrixCommand//(fallbackMethod = "queryUserByIdFailBak")
    public User queryUserById(@RequestParam(value = "id")String id){
//        List<ServiceInstance> instances = discoveryClient.getInstances("kong-service-privoder");
//        ServiceInstance serviceInstance = instances.get(0);
//        return this.restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/queryUserById/" + id,User.class);
//        if("1".equals(id)){
//            throw new RuntimeException();
//        }
//        return this.restTemplate.getForObject("http://kong-service-privoder/user/queryUserById/" + id,User.class);
        return userClient.queryUserById(Integer.valueOf(id));
    }

//    public User queryUserByIdFailBak(String id){
//        User user = new User();
//        user.setName("服务器正忙，请稍后再试!");
//        return user;
//    }
//
//    public User queryUserByIdFailBakDefault(){
//        User user = new User();
//        user.setName("服务器正忙，请稍后再试!");
//        return user;
//    }
}


package com.kong.controller;/**
 * Created by xuebi on 2019/7/31.
 */

import com.kong.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET)
    @ResponseBody
    public User queryUserById(@RequestParam(value = "id")String id){
        List<ServiceInstance> instances = discoveryClient.getInstances("kong-service-privoder");
        ServiceInstance serviceInstance = instances.get(0);
        return this.restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/queryUserById/" + id,User.class);
    }
}


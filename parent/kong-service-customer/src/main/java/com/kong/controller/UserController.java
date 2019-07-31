package com.kong.controller;/**
 * Created by xuebi on 2019/7/31.
 */

import com.kong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

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

    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET)
    @ResponseBody
    public User queryUserById(@RequestParam(value = "id")String id){
        return this.restTemplate.getForObject("http://localhost:8081/user/queryUserById/" + id,User.class);
    }
}


package com.kong.boot.controller;/**
 * Created by xuebi on 2019/9/9.
 */

import com.kong.bean.UserAddress;
import com.kong.service.OrderService;
import com.kong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/9 14:26
 * @Version 1.0
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/list")
    public void getUserList(@RequestParam("uid") String userId){
        orderService.initOrder(userId);
        System.out.println("服务消费端调用服务成功!");
    }
}

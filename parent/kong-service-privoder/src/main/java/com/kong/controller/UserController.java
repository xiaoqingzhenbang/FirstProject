package com.kong.controller;/**
 * Created by xuebi on 2019/7/31.
 */

import com.kong.pojo.User;
import com.kong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author xuebi
 * @Date 2019/7/31 14:52
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUserById/{id}",method = RequestMethod.GET)
    public User queryUserById(@PathVariable(value = "id")long id){
        return userService.queryUserById(id);
    }
}

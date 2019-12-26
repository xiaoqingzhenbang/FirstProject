package com.kong.controller;/**
 * Created by xuebi on 2019/12/20.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IMController
 * @Description TODO
 * @Author kongdeqi
 * @Date 2019/12/20 9:39
 * @Version 1.0
 */
@Controller()
@RequestMapping("/im")
public class IMController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("登录页面！");
        return "login/index";
    }
}

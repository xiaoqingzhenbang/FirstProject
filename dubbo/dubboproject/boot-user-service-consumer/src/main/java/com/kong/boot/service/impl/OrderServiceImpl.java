package com.kong.boot.service.impl;/**
 * Created by xuebi on 2019/9/6.
 */


import com.kong.bean.UserAddress;
import com.kong.service.OrderService;
import com.kong.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/6 15:13
 * @Version 1.0
 */

@Component
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(check = false,timeout = 3000)
    UserService userService;

    public void initOrder(String userId) {
        List<UserAddress> userAddressList =
                userService.getUserAddressList(userId);
        System.out.println(userAddressList);
    }
}

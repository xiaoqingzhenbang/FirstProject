package com.kong.service.impl;/**
 * Created by xuebi on 2019/9/6.
 */


import com.kong.bean.UserAddress;
import com.kong.service.OrderService;
import com.kong.service.UserService;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/6 15:13
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {

    UserService userService;

    public void initOrder(String userId) {
        List<UserAddress> userAddressList =
                userService.getUserAddressList(userId);
        System.out.println(userAddressList);
    }
}

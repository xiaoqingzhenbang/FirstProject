package com.kong.service.impl;/**
 * Created by xuebi on 2019/9/6.
 */

import com.kong.bean.UserAddress;
import com.kong.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/6 15:05
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    public List<UserAddress> getUserAddressList(String userId) {

        UserAddress userAddress1 = new UserAddress(1, "123", "回龙观", "孔老师", "123456", "1");
        UserAddress userAddress2 = new UserAddress(2, "456", "霍营", "闫老师", "456789", "0");
        List<UserAddress> userAddresses = Arrays.asList(userAddress1, userAddress2);

        return userAddresses;
    }
}

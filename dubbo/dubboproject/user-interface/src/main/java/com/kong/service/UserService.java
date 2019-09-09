package com.kong.service;/**
 * Created by xuebi on 2019/9/6.
 */

import com.kong.bean.UserAddress;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author xuebi
 * @Date 2019/9/6 15:05
 * @Version 1.0
 */
public interface UserService {

    List<UserAddress> getUserAddressList(String userId);
}

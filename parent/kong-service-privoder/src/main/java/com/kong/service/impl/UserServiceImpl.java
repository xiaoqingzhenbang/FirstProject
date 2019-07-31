package com.kong.service.impl;/**
 * Created by xuebi on 2019/7/31.
 */

import com.kong.mapper.UserMapper;
import com.kong.pojo.User;
import com.kong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author xuebi
 * @Date 2019/7/31 14:49
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(Long id) {
        return userMapper.queryUserById(id);
    }
}

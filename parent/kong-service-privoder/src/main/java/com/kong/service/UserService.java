package com.kong.service;

import com.kong.mapper.UserMapper;
import com.kong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xuebi on 2019/7/31.
 */
public interface UserService {

    User queryUserById(Long id);
}

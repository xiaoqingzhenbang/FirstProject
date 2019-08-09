package com.kong.client;/**
 * Created by xuebi on 2019/8/5.
 */

import com.kong.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserClientFallBak
 * @Description TODO
 * @Author xuebi
 * @Date 2019/8/5 10:29
 * @Version 1.0
 */
@Component
public class UserClientFallBak implements UserClient {

    @Override
    public User queryUserById(long id) {
        User user = new User();
        user.setName("服务器正忙，请稍后再试!");
        return user;
    }
}

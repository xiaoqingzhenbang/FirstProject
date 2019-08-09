package com.kong.client;

import com.kong.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xuebi on 2019/8/5.
 */
@FeignClient(value = "kong-service-privoder",fallback = UserClientFallBak.class)
public interface UserClient {

    @RequestMapping(value = "/user/queryUserById/{id}",method = RequestMethod.GET)
    User queryUserById(@PathVariable(value = "id")long id);
}

package com.kong.mapper;

import com.kong.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

/**
 * Created by xuebi on 2019/7/31.
 */

public interface UserMapper{

    @Select("SELECT * FROM user WHERE id = #{id}")
    User queryUserById(Long id);
}

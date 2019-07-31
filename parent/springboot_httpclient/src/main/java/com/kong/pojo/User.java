package com.kong.pojo;/**
 * Created by xuebi on 2019/7/30.
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author xuebi
 * @Date 2019/7/30 13:57
 * @Version 1.0
 */
@Data
public class User implements Serializable{

    private String id;
    private String name;
    private String age;
    private Date birth;

}

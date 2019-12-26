package com.xioakong.jsonobjectdemo;/**
 * Created by xuebi on 2019/11/27.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName JsonDemo
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/27 16:36
 * @Version 1.0
 */
public class JsonDemo {

    public static void main(String[] args) {
        String jsonStr = "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"xiaokong\",\n" +
                "\"age\":24,\n" +
                "\"birth\":\"1995-10-21\"\n" +
                "}";
        JSONObject o = json1(jsonStr);
        String id = o.get("id").toString();
        System.out.println(id);
    }

    private static JSONObject json1(String jsonStr){
        Object parse = JSON.parse(jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        return jsonObject;
    }
}

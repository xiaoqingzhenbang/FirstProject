package com.xioakong.jsonobjectdemo.controller;/**
 * Created by xuebi on 2019/11/28.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/28 14:03
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    /**
     * 查询供应商可融资产品列表
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping("/list")
    public Map financingProductList(@RequestParam(value = "pageSize",defaultValue = "0",required = false) Integer pageSize,
                                    @RequestParam(value = "pageNum",defaultValue = "20",required = false) Integer pageNum){

        return null;
    }

}

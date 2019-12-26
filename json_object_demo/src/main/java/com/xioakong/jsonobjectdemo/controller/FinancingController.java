package com.xioakong.jsonobjectdemo.controller;/**
 * Created by xuebi on 2019/11/28.
 */

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @ClassName FinancingController
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/28 14:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/financing")
public class FinancingController {

    /**
     * 保存上传资料
     * @param values
     * @param productId
     * @return
     */
    @RequestMapping("/information/save")
    public Map saveInformation(@RequestParam List<Map> values, @RequestParam("productId") String productId){

         //1.根据productId查询规则
         //2.解析规则
         //3.校验数据
         //4.调用excel解析
         //5.判断产品是否需要核心企业补传资料
         //6.保存数据
         //7.返回成功失败
        return null;
    }

    /**
     *提交上传资料
     * @param values
     * @param productId
     * @return
     */
    @RequestMapping("/information/commit")
    public Map commitInformation(@RequestParam List<Map> values,@RequestParam("productId") String productId){
        //1.根据productId查询规则
        //2.解析规则
        //3.校验数据
        //4.调用excel解析
        //5.判断产品是否需要核心企业补传资料
        //6.保存数据
        //7.更改状态
        //8.返回成功失败
        return null;
    }

    /**
     * 查询该供应商已申请的并被驳回的融资列表
     * @return
     */
    @RequestMapping("/product/list")
    public Map productList(){

        return null;
    }

    /**
     * 查询申贷资料详情
     * @return
     */
    @RequestMapping("/information/detail")
    public Map informationDetail(@RequestParam("id") String id){
        return null;
    }


    /**
     * 补传资料
     * @return
     */
    @RequestMapping(value = "/information/fill", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map informationFill(@RequestPart("file") MultipartFile file, @RequestParam("id") String id){
        return null;
    }
}

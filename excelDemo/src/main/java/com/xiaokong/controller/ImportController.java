package com.xiaokong.controller;/**
 * Created by xuebi on 2019/11/22.
 */

import com.xiaokong.service.ImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName ImportController
 * @Description TODO
 * @Author xuebi
 * @Date 2019/11/22 15:36
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/upload")
public class ImportController {
    private static final Logger log = LoggerFactory.getLogger(ImportController.class);

    @Autowired
    private ImportService importService;

    @RequestMapping(value = "/simple", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadSimpleFile(@RequestParam("file") MultipartFile file) throws Exception {

        String filename = file.getOriginalFilename();
        log.info("成功上传文件：" + filename);
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            //TODO 随意发挥
//            System.out.println(lo);

        }
        return "上传文件成功!";
    }
}

package com.kong;/**
 * Created by xuebi on 2019/7/30.
 */

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName HttpTests
 * @Description TODO
 * @Author xuebi
 * @Date 2019/7/30 14:09
 * @Version 1.0
 */
public class HttpTests {

    CloseableHttpClient httpClient;

    @Before
    public void init(){
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void testGet() throws IOException {
        HttpGet request = new HttpGet("http://www.baidu.com");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
    }

    @Test
    public void testPost() throws IOException {
        HttpPost request = new HttpPost("https://www.oschina.net/search?scope=project&q=java");
//        request.setHeader("Access-Control-Request-Headers","x-log-apiversion,x-log-bodyrawsize");
//        request.setHeader("Access-Control-Request-Method","POST");
//        request.setHeader("Origin","https://blog.csdn.net");
//        request.setHeader("Referer","https://blog.csdn.net/AmaniZ/article/details/79284853");
        request.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
    }
}

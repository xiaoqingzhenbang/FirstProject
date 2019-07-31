package com.kong.config;/**
 * Created by xuebi on 2019/7/31.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemlateConfig
 * @Description TODO
 * @Author xuebi
 * @Date 2019/7/31 15:59
 * @Version 1.0
 */

@Configuration
public class RestTemlateConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

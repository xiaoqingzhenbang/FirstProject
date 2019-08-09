package com.kong.config;/**
 * Created by xuebi on 2019/7/31.
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//    @Bean
//    public IRule mySelfRule(){
//        return new RandomRule();
//    }
}

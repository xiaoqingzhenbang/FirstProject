package com.kong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(value = "com.kong.mapper")
@EnableDiscoveryClient
public class KongServicePrivoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(KongServicePrivoderApplication.class, args);
	}

}

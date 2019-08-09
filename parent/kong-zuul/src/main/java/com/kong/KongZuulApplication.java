package com.kong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class KongZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(KongZuulApplication.class, args);
	}

}

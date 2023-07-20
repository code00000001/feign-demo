package com.demo.kebiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by code00000001 on 20/7/2023.
 */
@SpringBootApplication
@EnableFeignClients //开启feign注解，使Feign的bean注入
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}

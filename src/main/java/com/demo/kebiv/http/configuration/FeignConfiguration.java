package com.demo.kebiv.http.configuration;

import com.demo.kebiv.http.client.FeignClient;
import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by code00000001 on 20/7/2023.
 * 定义配置文件类，注入feignClient bean
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public Client feignClient() {
        return new FeignClient();
    }

}

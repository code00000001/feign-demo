package com.demo.kebiv.http.client;

import com.demo.kebiv.http.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by code00000001 on 20/7/2023.
 */
@FeignClient(value = "remote", url = "{feignUrl}", configuration = FeignConfiguration.class)
public interface RemoteClient {

    @GetMapping("/test/getString") // feignUrl+ /test/getString 为实际调用的远程地址
    String getString();
}

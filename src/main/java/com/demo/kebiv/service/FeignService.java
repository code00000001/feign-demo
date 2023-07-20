package com.demo.kebiv.service;

import com.demo.kebiv.http.client.RemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by code00000001 on 20/7/2023.
 */
@Service
public class FeignService {
    @Autowired
    private RemoteClient remoteClient; // Application启动类要先开启 @EnableFeignClients注解

    public String getString(){
        return remoteClient.getString();
    }
}

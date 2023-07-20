package com.demo.kebiv.controller;

import com.demo.kebiv.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by code00000001 on 20/7/2023.
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/test")
    public String getTest() {
        return feignService.getString();
    }

}

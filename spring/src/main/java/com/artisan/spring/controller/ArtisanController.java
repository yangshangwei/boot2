package com.artisan.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/22 17:55
 * @mark: show me the code , change the world
 */


@RestController
public class ArtisanController {



    @GetMapping("/test")
    public String test(){
        return "OK";
    }
}
    
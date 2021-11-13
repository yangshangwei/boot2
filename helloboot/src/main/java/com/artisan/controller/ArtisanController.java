package com.artisan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/1/9 22:39
 * @mark: show me the code , change the world
 */


@RestController
public class ArtisanController {


    @RequestMapping("/hi")
    public String test(){
        return "小工匠 每日一博";
    }
}
    
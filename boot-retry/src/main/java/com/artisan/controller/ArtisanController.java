package com.artisan.controller;

import com.artisan.service.ArtisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/11 16:56
 * @mark: show me the code , change the world
 */


@RestController
public class ArtisanController {


    @Autowired
    private ArtisanService artisanService;

    @GetMapping("/testRetry")
    public String test() {
        artisanService.test();
        return "OK";
    }
}
    
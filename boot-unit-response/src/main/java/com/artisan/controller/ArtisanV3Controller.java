package com.artisan.controller;

import com.artisan.entity.Artisan;
import com.artisan.resp.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/2/14 19:11
 * @mark: show me the code , change the world
 */

@RestController
@RequestMapping("/v3")
public class ArtisanV3Controller {


    @GetMapping("/getString")
    public String getStr() {
        return "OOOOOOK";
    }


    @GetMapping("/getArtisan")
    public Artisan getArt() {
        Artisan artisan = new Artisan();
        artisan.setJob("CodeMonkey");
        artisan.setAge(18);
        return artisan;
    }

    @GetMapping("/getMockError")
    public int getMockError() {
        int i = 1 / 0;
        return i;
    }


}
    
package com.artisan.controller;

import com.artisan.entity.Artisan;
import com.artisan.resp.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 版本2
 * @mark: show me the code , change the world
 */

@RestController
@RequestMapping("/v2")
public class ArtisanV2Controller {


    @GetMapping("/getString")
    public ResponseData<String> getStr() {
        return ResponseData.success("OOOOOOK");
    }


    @GetMapping("/getArtisan")
    public ResponseData<Artisan> getArt() {
        Artisan artisan = new Artisan();
        artisan.setJob("CodeMonkey");
        artisan.setAge(18);
        return ResponseData.success(artisan);
    }


    @GetMapping("/getMockError")
    public ResponseData<Integer> getMockError() {
        int i = 1 / 0;
        return ResponseData.success(i);
    }


}
    
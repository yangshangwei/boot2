package com.artisan.controller;

import com.artisan.entity.Artisan;
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

@RestController  // 返回JSON
@RequestMapping("/v1")
public class ArtisanV1Controller {


    /**
     * 返回字符串
     *
     * @return
     */
    @GetMapping("/getString")
    public String getStr() {
        return "OOOOOOOK";
    }

    /**
     * 返回自定义对象
     *
     * @return
     */
    @GetMapping("/getArtisan")
    public Artisan getArt() {
        Artisan artisan = new Artisan();
        artisan.setJob("ArtisanJob");
        artisan.setAge(18);
        return artisan;
    }


    /**
     * 接口异常
     *
     * @return
     */
    @GetMapping("/getMockError")
    public int getMockError() {
        int i = 1 / 0;
        return i;
    }


}
    
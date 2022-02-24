package com.artisan.controller;


import com.artisan.dao.ArtisanDao;
import com.artisan.entity.Artisan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */

@RestController
@Slf4j
@RequestMapping("/assert")
public class ArtisanController {

    @Autowired
    private ArtisanDao artisanDao;

    /**
     * Validator只解决了参数自身的数据校验，解决不了参数和业务数据之间校验
     *
     * @param
     * @return
     */
    @PostMapping("/testNoAssert")
    public void testNoAssert(@RequestParam("artisanId") String artisanId) {
        Artisan artisan = artisanDao.selectArtisanReturnNull(artisanId);

        if (artisan == null) {
            throw new IllegalArgumentException("用户不存在");
        }

    }


    /**
     * Validator只解决了参数自身的数据校验，解决不了参数和业务数据之间校验
     *
     * @param
     * @return
     */
    @PostMapping("/testWithAssert")
    public void testWithAssert(@RequestParam("artisanId") String artisanId) {
        Artisan artisan = artisanDao.selectArtisanReturnNull(artisanId);

        Assert.notNull(artisan, "用户不存在（Assert抛出）");

    }

}
    
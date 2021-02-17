package com.artisan.controller;

import com.artisan.common.CommonResult;
import com.artisan.domain.Artisan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/16 14:42
 * @mark: show me the code , change the world
 */
@RestController
public class ArtisanController  extends BaseController {



    @GetMapping("/mockSet")
    public CommonResult set(@RequestParam("key") String key, @RequestParam("value") String value) {

        Artisan artisan = new Artisan();
        artisan.setName(key);
        artisan.setAddress("匠心工作室");
        artisan.setAge(18);

        getHttpSession().setAttribute("artisan", artisan);

        return CommonResult.success("成功模拟登录");
    }


    @GetMapping("/mockGet")
    public CommonResult get(@RequestParam("key") String key) {
        return CommonResult.success( getHttpSession().getAttribute(key));
    }


}
    
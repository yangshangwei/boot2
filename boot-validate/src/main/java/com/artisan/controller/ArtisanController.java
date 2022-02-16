package com.artisan.controller;

import com.artisan.vo.Artisan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */

@RestController
@Slf4j
@Validated
@RequestMapping("/valid")
public class ArtisanController {


    /**
     * 使用了@RequestBody注解，用于接受前端发送的json数据
     *
     * @param artisan
     * @return
     */
    @PostMapping("/testJson")
    public String testJson(@Validated @RequestBody Artisan artisan) {
        log.info("InComing Param  {}", artisan);
        return "testJson valid success";
    }

    /**
     * 模拟表单提交
     *
     * @param artisan
     * @return
     */
    @PostMapping(value = "/testForm")
    public String testForm(@Validated Artisan artisan) {
        log.info("InComing Param is {}", artisan);
        return "testForm valid success";
    }

    /**
     * 模拟单参数提交
     * <p>
     * 当使用单参数校验时需要在Controller上加上@Validated注解，否则不生效
     *
     * @param email
     * @return
     */
    @PostMapping(value = "/testParma")
    public String testParma(@Email String email) {
        log.info("InComing Param is {}", email);
        return "testParma  valid success";
    }


}
    
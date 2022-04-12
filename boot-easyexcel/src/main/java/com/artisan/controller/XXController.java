package com.artisan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/3/30 22:02
 * @mark: show me the code , change the world
 */

@Api(tags = "XXX 木块")
@RestController
public class XXController {

    @ApiOperation(value = "TestBootJAR API ")
  //  @ApiImplicitParam(name = "name", value = "姓名", required = true)

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="name",value = "姓名",required = true,defaultValue = "张三"),
            @ApiImplicitParam(paramType = "query",name="num",value = "年龄",required = true,defaultValue = "18")
    })
    @GetMapping("/testBootJar")
    public ResponseEntity<String> testBootJar(@RequestParam(value = "name") String name, Integer num) {
        return ResponseEntity.ok("Hi:" + name + "," + num);
    }
}
    
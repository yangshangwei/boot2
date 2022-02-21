package com.artisan;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/2/20 1:03
 * @mark: show me the code , change the world
 */

@SpringBootApplication
public class ApplcationBuilderDemo {

    public static void main(String[] args) {

        SpringApplication.run(ApplcationBuilderDemo.class, args);

        // 关闭banner  关闭启动信息
        new SpringApplicationBuilder(ApplcationBuilderDemo.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .build()
                .run(args);
    }
}
    
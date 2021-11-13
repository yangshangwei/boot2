package com.artisan.spring.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/20 11:09
 * @mark: show me the code , change the world
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(AppConfig.class);


        System.out.println(context.getBeanDefinitionNames());
    }
}
    
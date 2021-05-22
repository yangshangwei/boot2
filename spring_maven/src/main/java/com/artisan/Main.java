package com.artisan;

import com.artisan.beans.Artisan;
import com.artisan.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/22 9:17
 * @mark: show me the code , change the world
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Artisan artisan =  ctx.getBean(Artisan.class);
        System.out.println(artisan);
    }
}
    
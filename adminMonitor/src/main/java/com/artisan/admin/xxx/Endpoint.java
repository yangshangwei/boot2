package com.artisan.admin.xxx;

import java.lang.annotation.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/30 20:25
 * @mark: show me the code , change the world
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Endpoint {


    //端点 id
    String id() default "";

    //是否默认启动标志位
    boolean enableByDefault() default true;

}
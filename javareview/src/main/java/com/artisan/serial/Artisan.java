package com.artisan.serial;

import java.io.Serializable;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/12 19:07
 * @mark: show me the code , change the world
 */
public class Artisan implements Serializable {

    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
    
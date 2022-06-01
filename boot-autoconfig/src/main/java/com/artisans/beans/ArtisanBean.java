package com.artisans.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/4/12 23:47
 * @mark: show me the code , change the world
 */
public class ArtisanBean {

    @Value("小工匠")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
    
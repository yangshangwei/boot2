package com.artisan.bfzm.edaPrac;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 10:02
 * @mark: show me the code , change the world
 */
public class Event implements Message {

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
    
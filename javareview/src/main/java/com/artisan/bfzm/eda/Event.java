package com.artisan.bfzm.eda;

/**
 * @author 小工匠
 * @version 1.0
 * @description: Event只包含了该Event所属的类型和所包含的数据
 * @date 2022/1/7 20:55
 * @mark: show me the code , change the world
 */
public class Event {

    private final String type;
    private final String data;

    public Event(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
    
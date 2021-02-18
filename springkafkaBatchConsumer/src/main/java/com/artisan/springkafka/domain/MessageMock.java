package com.artisan.springkafka.domain;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/17 22:27
 * @mark: show me the code , change the world
 */
public class MessageMock {

    private Integer id ;
    private String name ;

    public MessageMock() {
    }

    public MessageMock(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "MessageMock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
    
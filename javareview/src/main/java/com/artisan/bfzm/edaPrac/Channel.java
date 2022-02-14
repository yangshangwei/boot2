package com.artisan.bfzm.edaPrac;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 9:56
 * @mark: show me the code , change the world
 */
public interface Channel<E extends Message> {

    /**
     * dispatch方法用于message的调度
     *
     * @param message
     */
    void handle(E message);
}
    
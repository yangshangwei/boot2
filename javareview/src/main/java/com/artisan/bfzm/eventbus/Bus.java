package com.artisan.bfzm.eventbus;

/**
 * Bus接口定义了EventBus的所有使用方法
 *
 * @author artisan
 */
public interface Bus {


    /**
     * 将某个对象注册到Bus上，从此之后该类就成为Subscriber了
     */
    void register(Object subscriber);

    /**
     * 将某个对象从Bus上取消注册，取消注册之后就不会再接收到来自Bus的任何消息
     */
    void unregister(Object subscriber);

    /**
     * 提交Event到默认的topic
     */
    void post(Object event);

    /**
     * 提交Event到指定的topic
     */
    void post(Object event, String topic);

    /**
     * 关闭该bus
     */
    void close();

    /**
     * 返回Bus的名称标识
     */
    String getBusName();

}

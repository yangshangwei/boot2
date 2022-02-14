package com.artisan.bfzm.edaPrac;

public interface Message {

    /**
     * 返回Message的类型
     */

    Class<? extends Message> getType();
}

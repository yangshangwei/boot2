package com.artisan.bfzm.edaPrac;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 9:57
 * @mark: show me the code , change the world
 */
public interface DynamicRouter<E extends Message> {

    /**
     * 针对每一种Message类型注册相关的Channel，只有找到合适的Channel该Message才会被处理
     *
     * @param messageType
     * @param channel
     */
    void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel);

    /**
     * 为相应的Channel分配Message
     */
    void dispatch(E message);


}
    
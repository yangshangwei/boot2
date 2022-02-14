package com.artisan.bfzm.edaPrac;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小工匠
 * @version 1.0
 * @description: EventDispatcher不是一个线程安全的类
 * @date 2022/1/11 10:04
 * @mark: show me the code , change the world
 */
public class EventDispatcher implements DynamicRouter<Message> {

    /**
     * 用于保存 Channel和 Message的对应关系
     */
    private final Map<Class<? extends Message>, Channel> routerTable;

    public EventDispatcher() {
        // 初始化RouterTable,但是在该实现中，我们使用HashMap作为路由表
        this.routerTable = new HashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel) {
        routerTable.put(messageType, channel);
    }

    @Override
    public void dispatch(Message message) {
        if (routerTable.containsKey(message.getType())) {
            // 直接获取对应的Channel处理Message
            routerTable.get(message.getType()).handle(message);
        } else {
            throw new MessageMatcherExecption("Can't match the channel for [" + message.getType() + "] type");
        }
    }
}
    
package com.artisan.bfzm.edaPrac.async;

import com.artisan.bfzm.edaPrac.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 13:59
 * @mark: show me the code , change the world
 */
public class AsyncEventDispatcher implements DynamicRouter<Event> {

    /**
     * 使用线程安全的ConcurrentHashMap替换HashMap
     */
    private final Map<Class<? extends Message>, AsyncChannel> routeTable;


    public AsyncEventDispatcher() {
        routeTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel) {
        // 在AsyncEventDispatcher中，Channel必须是AsyncChannel类型
        if (!(channel instanceof AsyncChannel)) {
            throw new IllegalArgumentException("The channel must be AsyncChannel Type.");
        }
        this.routeTable.put(messageType, (AsyncChannel) channel);
    }

    @Override
    public void dispatch(Event event) {
        if (this.routeTable.containsKey(event.getType())) {
            this.routeTable.get(event.getType()).handle(event);
        } else {
            throw new MessageMatcherExecption("Can't match the channel for [" + event.getType() + "] type");
        }
    }

    /**
     * 关闭所有的Channel以释放资源
     */
    public void release() {
        this.routeTable.values().forEach(AsyncChannel::stop);
    }
}
    
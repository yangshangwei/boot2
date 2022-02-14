package com.artisan.bfzm.edaPrac.async;

import com.artisan.bfzm.edaPrac.Channel;
import com.artisan.bfzm.edaPrac.Event;
import com.artisan.bfzm.edaPrac.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步EDA框架设计
 * @author artisan
 */
public abstract class AsyncChannel implements Channel<Event> {

    private final ExecutorService executorService;

    /**
     * 默认构造函数，提供了CPU的核数×2的线程数量
     */
    public AsyncChannel() {
        executorService = Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors(),
                new NamedThreadFactory("Event-Handler-Pool-", false));
    }

    /**
     * 用户自定义的ExecutorService
     *
     * @param executorService
     */
    AsyncChannel(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /**
     * 重写dispatch方法，并且用final修饰，避免子类重写
     *
     * @param event
     */
    @Override
    public final void handle(Event event) {
        executorService.submit(() -> dealEvent(event));
    }

    /**
     * 提供抽象方法，供子类实现具体的Message处理
     */
    protected abstract void dealEvent(Event event);


    /**
     * 提供关闭ExecutorService的方法
     */
    void stop() {
        if (null != executorService && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

}

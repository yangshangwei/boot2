package com.artisan.bfzm.eventbus;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/12/2 00:12
 * @mark: show me the code , change the world
 */
public class Dispatcher {

    private final Executor executorService;
    private final EventExceptionHandler exceptionHandler;

    public static final Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.INSTANCE;

    public static final Executor PRE_THREAD_EXECUTOR_SERVICE = PreThreadExecutorService.INSTANCE;

    private Dispatcher(Executor executorService, EventExceptionHandler exceptionHandler) {
        this.executorService = executorService;
        this.exceptionHandler = exceptionHandler;
    }

    public void dispatch(Bus bus, Registry registry, Object event, String topic) {
        //根据topic获取所有的Subscriber列表
        ConcurrentLinkedQueue<Subscriber> subscribers = registry.scanSubscriber(topic);
        if (null == subscribers) {
            if (exceptionHandler != null) {
                exceptionHandler.handle(new IllegalArgumentException("The topic " + topic + " not bind yet"),
                        new BaseEventContext(bus.getBusName(), null, event));
            }
            return;
        }

        //遍历所有的方法，并且通过反射的方式进行方法调用
        subscribers.stream()
                .filter(subscriber -> !subscriber.isDisable())
                .filter(subscriber ->
                {
                    Method subscribeMethod = subscriber.getSubscribeMethod();
                    Class<?> aClass = subscribeMethod.getParameterTypes()[0];
                    return (aClass.isAssignableFrom(event.getClass()));
                }).forEach(subscriber -> realInvokeSubscribe(subscriber, event, bus));
    }

    private void realInvokeSubscribe(Subscriber subscriber, Object event, Bus bus) {
        Method subscribeMethod = subscriber.getSubscribeMethod();
        Object subscribeObject = subscriber.getSubscribeObject();
        executorService.execute(() -> {
            try {
                subscribeMethod.invoke(subscribeObject, event);
            } catch (Exception e) {
                if (null != exceptionHandler) {
                    exceptionHandler.handle(e, new BaseEventContext(bus.getBusName(), subscriber, event));
                }
            }
        });
    }

    public void close() {
        if (executorService instanceof ExecutorService) {
            ((ExecutorService) executorService).shutdown();
        }
    }

    static Dispatcher newDispatcher(EventExceptionHandler exceptionHandler, Executor executor) {
        return new Dispatcher(executor, exceptionHandler);
    }

    static Dispatcher seqDispatcher(EventExceptionHandler exceptionHandler) {
        return new Dispatcher(SEQ_EXECUTOR_SERVICE, exceptionHandler);
    }

    static Dispatcher perThreadDispatcher(EventExceptionHandler exceptionHandler) {
        return new Dispatcher(PRE_THREAD_EXECUTOR_SERVICE, exceptionHandler);
    }

    /**
     * 顺序执行的ExecutorService
     */
    private static class SeqExecutorService implements Executor {

        private final static SeqExecutorService INSTANCE = new SeqExecutorService();

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    /**
     * 每个线程负责一次消息推送
     */
    private static class PreThreadExecutorService implements Executor {
        private final static PreThreadExecutorService INSTANCE = new PreThreadExecutorService();

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    /**
     * 默认的EventContext实现
     */
    private static class BaseEventContext implements EventContext {
        private final String eventBusName;

        private final Subscriber subscriber;

        private final Object event;

        private BaseEventContext(String eventBusName, Subscriber subscriber, Object event) {
            this.eventBusName = eventBusName;
            this.subscriber = subscriber;
            this.event = event;
        }

        @Override
        public String getSource() {
            return this.eventBusName;
        }

        @Override
        public Object getSubscriber() {
            return subscriber != null ? subscriber.getSubscribeObject() : null;
        }

        @Override
        public Method getSubscribe() {
            return subscriber != null ? subscriber.getSubscribeMethod() : null;
        }

        @Override
        public Object getEvent() {
            return this.event;
        }
    }
}
    
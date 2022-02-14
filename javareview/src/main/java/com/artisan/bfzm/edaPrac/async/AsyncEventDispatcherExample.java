package com.artisan.bfzm.edaPrac.async;

import com.artisan.bfzm.edaPrac.Event;
import com.artisan.bfzm.edaPrac.NamedThreadFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 14:11
 * @mark: show me the code , change the world
 */
public class AsyncEventDispatcherExample {

    /**
     * InputEvent中定义了两个属性X和Y，主要用于在其他Channel中的运算
     */
    static class InputEvent extends Event {
        private final int x;
        private final int y;

        public InputEvent(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    /**
     * 用于存放结果的Event
     */
    static class ResultEvent extends Event {

        private final int result;

        public ResultEvent(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }
    }

    static class AsyncInputEventHandler extends AsyncChannel {

        private final AsyncEventDispatcher dispatcher;


        AsyncInputEventHandler(AsyncEventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        /**
         * 不同于以同步的方式实现，异步的方式需要实现handle
         *
         * @param event
         */
        @Override
        protected void dealEvent(Event event) {
            InputEvent inputEvent = (InputEvent) event;
            System.out.println(Thread.currentThread().getName() + " - " + this.getClass().getSimpleName() + " - 开始处理:" + event.getType().getName());

            // 模拟耗时任务
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int result = inputEvent.getX() + inputEvent.getY();
            dispatcher.dispatch(new ResultEvent(result));
        }
    }

    /**
     * 主要用于处理InputEvent，但是需要继承AsyncChannel
     */
    static class AsyncResultEventHandler extends AsyncChannel {


        @Override
        protected void dealEvent(Event event) {
            System.out.println(Thread.currentThread().getName() + " - " + this.getClass().getSimpleName() + " - 开始处理:" + event.getType().getName());
            ResultEvent resultEvent = (ResultEvent) event;

            // 模拟耗时任务
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - The result is:" + resultEvent.getResult());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //定义AsyncEventDispatcher
        AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();

        //注册Event和Channel之间的关系
        dispatcher.registerChannel(InputEvent.class, new AsyncInputEventHandler(dispatcher));
        dispatcher.registerChannel(ResultEvent.class, new AsyncResultEventHandler());
        //提交需要处理的Message
        dispatcher.dispatch(new InputEvent(1, 2));
        dispatcher.dispatch(new InputEvent(3, 4));
        dispatcher.dispatch(new InputEvent(5, 7));
        dispatcher.dispatch(new InputEvent(5, 8));
        dispatcher.dispatch(new InputEvent(7, 9));

        TimeUnit.SECONDS.sleep(20);
        dispatcher.release();
    }
}
    
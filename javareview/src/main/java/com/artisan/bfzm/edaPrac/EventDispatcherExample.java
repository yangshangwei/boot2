package com.artisan.bfzm.edaPrac;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 10:13
 * @mark: show me the code , change the world
 */
public class EventDispatcherExample {

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

    /**
     * 处理ResultEvent的Handler（Channel），只是简单地将计算结果输出到控制台
     */
    static class ResultEventHandler implements Channel<ResultEvent> {

        @Override
        public void handle(ResultEvent message) {
            System.out.println(Thread.currentThread().getName() + " - The result is:" + message.getResult());
        }
    }

    /**
     * InputEventHandler需要向Router发送Event，因此在构造的时候需要传入Dispatcher
     */
    static class InputEventHandler implements Channel<InputEvent> {

        private final EventDispatcher eventDispatcher;

        public InputEventHandler(EventDispatcher eventDispatcher) {
            this.eventDispatcher = eventDispatcher;
        }

        /**
         * 将计算的结果构造成新的Event提交给Router
         *
         * @param message
         */
        @Override
        public void handle(InputEvent message) {
            System.out.println(Thread.currentThread().getName() + " - " + this.getClass().getSimpleName() + " - 开始处理:" + message.getType().getName());
            int result = message.getX() + message.getY();
            eventDispatcher.dispatch(new ResultEvent(result));
        }

        public static void main(String[] args) {
            // 构造Router
            EventDispatcher eventDispatcher = new EventDispatcher();

            // 将Event和Handler（Channel）的绑定关系注册到Dispatcher
            eventDispatcher.registerChannel(InputEvent.class, new InputEventHandler(eventDispatcher));
            eventDispatcher.registerChannel(ResultEvent.class, new ResultEventHandler());

            eventDispatcher.dispatch(new InputEvent(1, 2));
            eventDispatcher.dispatch(new InputEvent(2, 2));
            eventDispatcher.dispatch(new InputEvent(3, 2));
        }

    }

}
    
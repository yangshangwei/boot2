package com.artisan.lesson01.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 小工匠
 * @version 1.0
 * @description: Spring 事件 - addApplicationListener
 * @date 2022/5/22 9:14
 * @mark: show me the code , change the world
 */
public class EventListenerDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

        ac.addApplicationListener(new MyApplicationListener());

        ac.refresh();

        ac.publishEvent(new MyEvent("xxxx"));

    }


    private static class MyApplicationListener implements ApplicationListener<MyEvent> {


        @Override
        public void onApplicationEvent(MyEvent event) {
            System.out.println(event.getSource());
        }
    }


    private static class MyEvent extends ApplicationEvent {

        /**
         * Create a new {@code ApplicationEvent}.
         *
         * @param source the object on which the event initially occurred or with
         *               which the event is associated (never {@code null})
         */
        public MyEvent(Object source) {
            super(source);
        }
    }
}
    
package com.artisan.bfzm.eda;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 小工匠
 * @version 1.0
 * @description:
 *
 * ·Events：需要被处理的数据。
 *
 * ·Event Handlers：处理Events的方式方法。
 *
 * ·Event Loop：维护Events和Event Handlers之间的交互流程。
 *
 * @date 2022/1/11 9:42
 * @mark: show me the code , change the world
 */
public class EventTest {

    /**
     * 处理事件A -- 小写
     */
    public static void handleA(Event event) {
        System.out.println(String.format("A execute: type %s , data %s", event.getType(), event.getData().toLowerCase()));
    }

    /**
     * 处理事件B -- 大写
     */
    public static void handleB(Event event) {
        System.out.println(String.format("B execute: type %s , data %s", event.getType(), event.getData().toUpperCase()));
    }

    public static void main(String[] args) {

        Queue<Event> eventQueue = new LinkedList<>();
        eventQueue.add(new Event("A", "A-HaHa"));
        eventQueue.add(new Event("A", "Event A message"));
        eventQueue.add(new Event("B", "B-HaHa"));
        eventQueue.add(new Event("B", "Event B message"));

        Event event;
        while (!eventQueue.isEmpty()) {
            //从消息队列中不断移除，根据不同的类型进行处理
            event = eventQueue.remove();
            switch (event.getType()) {
                case "A":
                    handleA(event);
                    break;
                case "B":
                    handleB(event);
                    break;
                default:
                    break;
            }

        }

    }
}
    
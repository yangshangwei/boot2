package com.artisan.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/9/2 22:50
 * @mark: show me the code , change the world
 */
public class TicketDelay implements Delayed {

    private String ticketId;
    private long timeout;

    public TicketDelay(String ticketId, long timeout) {
        this.ticketId= ticketId;
        this.timeout = timeout + System.nanoTime();
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this) {
            return 0;
        }

        TicketDelay t = (TicketDelay) other;
        long d = (getDelay(TimeUnit.NANOSECONDS) - t.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    /**
     * 返回距离自定义的超时时间还有多少
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    void doSomething() {
        System.out.println(ticketId+" is deleted");
    }
}
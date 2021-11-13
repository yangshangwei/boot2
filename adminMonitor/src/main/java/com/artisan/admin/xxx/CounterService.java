package com.artisan.admin.xxx;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.stereotype.Component;

/**
 * @author 小工匠
 * @version 1.0
 * @description:
 * @date 2021/5/30 19:16
 * @mark: show me the code , change the world
 */
@Component
public class CounterService {

    public CounterService() {
        Metrics.addRegistry(new SimpleMeterRegistry());
    }



    public void counter(String name, String... tags) {
        Counter counter = Metrics.counter(name, tags);
        counter.increment();
    }
}
    
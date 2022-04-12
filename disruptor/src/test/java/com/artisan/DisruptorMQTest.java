package com.artisan;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/4/9 7:55
 * @mark: show me the code , change the world
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DisruptorMQApplcaiton.class)
public class DisruptorMQTest {

    @Autowired
    private DisruptorMQService disruptorMqService;

    /**
     * 项目内部使用Disruptor做消息队列
     *
     * @throws Exception
     */
    @Test
    public void sayHelloMqTest() throws Exception {
        disruptorMqService.testSendMessage("消息FROM DISRUPTOR!");
        log.info("消息队列已发送完毕");
        //这里停止2000ms是为了确定是处理消息是异步的
        Thread.sleep(2000);
    }
}
    
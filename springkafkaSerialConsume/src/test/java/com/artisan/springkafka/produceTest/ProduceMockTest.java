package com.artisan.springkafka.produceTest;

import com.artisan.springkafka.SpringkafkaApplication;
import com.artisan.springkafka.producer.ArtisanProducerMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author 小工匠
 * * @version 1.0
 * @description: TODO
 * @date 2021/2/17 22:40
 * @mark: show me the code , change the world
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringkafkaApplication.class)
public class ProduceMockTest {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ArtisanProducerMock artisanProducerMock;


    @Test
    public void testAsynSend() throws ExecutionException, InterruptedException {
        logger.info("开始发送");

        // 模拟发送多条消息
        for (int i = 0; i < 5; i++) {
            SendResult sendResult = artisanProducerMock.sendMsgSync();

            logger.info("key {} . 分区:{}",sendResult.getProducerRecord().key(),sendResult.getRecordMetadata().partition());

            SendResult sendResult1 = artisanProducerMock.sendMsgSync2();

            logger.info("key {} . 分区:{}",sendResult1.getProducerRecord().key(),sendResult1.getRecordMetadata().partition());
        }


        // 阻塞等待，保证消费
        new CountDownLatch(1).await();

    }

}
    
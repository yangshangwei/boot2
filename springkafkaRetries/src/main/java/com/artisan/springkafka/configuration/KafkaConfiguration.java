package com.artisan.springkafka.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.*;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/18 14:32
 * @mark: show me the code , change the world
 */

@Configuration
public class KafkaConfiguration {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Bean
    @Primary
    public ErrorHandler kafkaErrorHandler(KafkaTemplate<?, ?> template) {

        logger.warn("kafkaErrorHandler begin to Handle");

        // <1> 创建 DeadLetterPublishingRecoverer 对象
        ConsumerRecordRecoverer recoverer = new DeadLetterPublishingRecoverer(template);
        // <2> 创建 FixedBackOff 对象   设置重试间隔 10秒 次数为 3次
        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);
        // <3> 创建 SeekToCurrentErrorHandler 对象
        return new SeekToCurrentErrorHandler(recoverer, backOff);
    }



//    @Bean
//    @Primary
//    public BatchErrorHandler kafkaBatchErrorHandler() {
//        // 创建 SeekToCurrentBatchErrorHandler 对象
//        SeekToCurrentBatchErrorHandler batchErrorHandler = new SeekToCurrentBatchErrorHandler();
//        // 创建 FixedBackOff 对象
//        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);
//        batchErrorHandler.setBackOff(backOff);
//        // 返回
//        return batchErrorHandler;
//    }
}
    
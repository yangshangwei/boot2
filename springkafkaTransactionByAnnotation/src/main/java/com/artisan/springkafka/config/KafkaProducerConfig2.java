package com.artisan.springkafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.transaction.KafkaTransactionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/20 10:43
 * @mark: show me the code , change the world
 */

@Configuration
@EnableKafka
public class KafkaProducerConfig2 {

    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;
    @Value("${spring.kafka.producer.retries}")
    private int retries;
//    @Value("${spring.kafka.producer.batch.size}")
//    private int batchSize;
//    @Value("${spring.kafka.producer.linger}")
//    private int linger;
//    @Value("${kafka.producer.buffer.memory}")
//    private int bufferMemory;

    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
     //   props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.126.140:9092");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);

        props.put(ProducerConfig.RETRIES_CONFIG, retries);
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
//        props.put(ProducerConfig.LINGER_MS_CONFIG, linger);
//        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        DefaultKafkaProducerFactory factory = new DefaultKafkaProducerFactory<>(producerConfigs());
        factory.transactionCapable();
        factory.setTransactionIdPrefix("artisan-tran-");
        return factory;
    }

    @Bean
    public KafkaTransactionManager transactionManager(ProducerFactory producerFactory) {
        KafkaTransactionManager manager = new KafkaTransactionManager(producerFactory);
        return manager;
    }


    @Bean
    public KafkaTemplate kafkaTemplate(){
        return  new KafkaTemplate(producerFactory());
    }
}
    
package com.netease;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.BytesSerializer;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangchanglu on 2017/11/16
 * email hzzhangchanglu@corp.netease.com
 *
 * @author zhangchanglu
 */
@Configuration
@EnableKafka
@PropertySource({"classpath:config/${spring.profiles.active}/kafka.properties"})
public class KafkaProducerConfig {
    @Value("${kafka.binder.brokers}")
    private String brokers;
    @Value("${kafka.producer.key-serializer}")
    private String keySerializer;
    @Value("${kafka.producer.value-serializer}")
    private String valueSerializer;
    @Value("${kafka.producer.batch-size}")
    private int batchSize;
    @Value("${kafka.producer.linger-ms}")
    private int lingerMs;
    @Value("${kafka.producer.buffer-memory}")
    private int bufferMemory;

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public Producer producer() {
        return producerFactory().createProducer();
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> properties = new HashMap<>(6);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        return new DefaultKafkaProducerFactory<>(properties,new StringSerializer(),new JsonSerializer<>());
    }
}

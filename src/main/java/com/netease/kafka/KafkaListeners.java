package com.netease.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by zhangchanglu on 2017/11/16
 * email hzzhangchanglu@corp.netease.com
 *
 * @author zhangchanglu
 */
@Component
public class KafkaListeners {
    @KafkaListener(topics = "kada")
    public void listener(ConsumerRecord<?, ?> record) {
        Optional<?> messages = Optional.ofNullable(record.value());
        if (messages.isPresent()) {
            System.out.println("one-"+messages.get());
        }
    }
    @KafkaListener(topics = "kada")
    public void listener2(ConsumerRecord<?, ?> record) {
        Optional<?> messages = Optional.ofNullable(record.value());
        if (messages.isPresent()) {
            System.out.println("tow-"+messages.get());
        }
    }
}

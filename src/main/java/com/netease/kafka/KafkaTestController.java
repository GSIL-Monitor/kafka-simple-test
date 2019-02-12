package com.netease.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by zhangchanglu on 2017/11/16
 * email zclsoft@163.com
 *
 * @author zhangchanglu
 */
@Controller
@RequestMapping("/kafka")
public class KafkaTestController {
    @Value("${kafka.topic}")
    private String topic;
    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;
    @RequestMapping("/send")
    public String send(String value) {
        kafkaTemplate.send(topic,value);
        return "send success";
    }
}

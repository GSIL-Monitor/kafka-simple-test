package com.netease.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by zhangchanglu on 2017/11/16
 * email hzzhangchanglu@corp.netease.com
 *
 * @author zhangchanglu
 */
@Controller
@RequestMapping("/kafka")
public class KafkaTestController {
    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;
    @RequestMapping("/send")
    public String send(String value) {
        kafkaTemplate.send("kada",value);
        return "send success";
    }
}

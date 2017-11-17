### 环境搭建
- 搭建你本机kafka服务，如果有可用的可用直接配置kafka.properties更改brokers
- springboot工程启动
- 浏览器访问对应接口发送测试消息
  - [http://127.0.0.1:8080/kafka/send?value=hello,world](http://127.0.0.1:8080/kafka/send?value=hello,world)
  - 查看控制台输出 hello,world


### 结构说明
类名| 作用
---|---
KafkaConsumerConfig|消费者配置
KafkaProducerConfig   |    生产者配置
KafkaListeners         |   spring支持的注解@KafkaListener监听对应topic消息
KafkaTestController    |   消息发送测试接口
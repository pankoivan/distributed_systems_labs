package com.distributed_systems_labs;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "msg")
    public void msgListener(String msg) {
        System.out.println(msg);
    }

}

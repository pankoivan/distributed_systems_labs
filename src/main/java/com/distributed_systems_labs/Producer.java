package com.distributed_systems_labs;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/msg")
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public void send(String msgId, String msg) {
        kafkaTemplate.send("msg", msgId, msg);
    }

}

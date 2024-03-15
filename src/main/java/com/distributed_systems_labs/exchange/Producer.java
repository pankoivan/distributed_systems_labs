package com.distributed_systems_labs.exchange;

import com.distributed_systems_labs.entities.Car;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/send-car")
public class Producer {

    private final KafkaTemplate<String, Car> kafkaTemplate;

    @PostMapping
    public void send(@RequestBody Car car) {
        kafkaTemplate.send("cars-topic", car);
    }

}

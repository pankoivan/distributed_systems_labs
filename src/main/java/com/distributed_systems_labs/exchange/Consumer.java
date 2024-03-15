package com.distributed_systems_labs.exchange;

import com.distributed_systems_labs.entities.Car;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Consumer {

    @KafkaListener(topics = "cars-topic")
    public void listen(Car car) {
        System.out.printf(
                "\n\n\n--- %s ---\n\nМарка: %s\nМодель: %s\nГод: %s\n\n\n",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss")),
                car.getBrand(),
                car.getModel(),
                car.getYear()
        );
    }

}

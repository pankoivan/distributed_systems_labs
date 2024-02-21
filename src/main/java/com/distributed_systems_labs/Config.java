package com.distributed_systems_labs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

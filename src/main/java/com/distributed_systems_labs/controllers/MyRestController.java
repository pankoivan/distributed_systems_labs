package com.distributed_systems_labs.controllers;

import com.distributed_systems_labs.entitites.Countries;
import com.distributed_systems_labs.entitites.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class MyRestController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${key}")
    private String key;

    @PostMapping("/search")
    public List<String> searchCountries(@RequestBody(required = false) String search) throws RestClientException {
        search = search == null ? "" : search;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Token %s".formatted(key));
        return restTemplate.exchange(
                        "http://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/country",
                        HttpMethod.POST,
                        new HttpEntity<>(Map.of("query", search), httpHeaders),
                        Countries.class
                )
                .getBody()
                .getCountries()
                .stream()
                .map(Country::getName)
                .limit(10)
                .toList();
    }

}

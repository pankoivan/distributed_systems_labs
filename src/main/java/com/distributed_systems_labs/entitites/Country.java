package com.distributed_systems_labs.entitites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Country {

    @JsonProperty("value")
    private String name;

}

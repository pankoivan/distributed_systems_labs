package com.distributed_systems_labs.entitites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Countries {

    @JsonProperty("suggestions")
    private List<Country> countries;

}

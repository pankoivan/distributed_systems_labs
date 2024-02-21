package com.distributed_systems_labs;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Multiplier {

    @PostMapping("/multiply")
    public Response multiply(@RequestBody Request request) {
        return new Response(request.getAmount() * request.getRate());
    }

}

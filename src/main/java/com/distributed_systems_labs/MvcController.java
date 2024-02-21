package com.distributed_systems_labs;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Controller
public class MvcController {

    private final RestTemplate restTemplate;

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/info")
    public String info(Model model, Request request) {
        model.addAttribute("response", getResponse(request));
        return "info";
    }

    private Response getResponse(Request request) {
        return restTemplate.postForEntity("http://localhost:8081/multiply", request, Response.class).getBody();
    }

}

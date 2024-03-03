package com.distributed_systems_labs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyMvcController {

    @GetMapping({"/", "/index", "/main"})
    public String index() {
        return "index";
    }

}

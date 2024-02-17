package com.distributed_systems_labs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcController {

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/info")
    public String info(Model model, Info info) {
        model.addAttribute("result", info.getAmount() * info.getRate());
        return "info";
    }

}

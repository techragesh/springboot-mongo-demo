package com.techragesh.sprinbootmongodemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerUIController {

    @GetMapping("/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}

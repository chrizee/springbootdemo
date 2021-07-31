package com.example;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/rest")
    public String rest() {
        return "Json from rest";
    }
}

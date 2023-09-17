package com.example.homework.HomeWork12_Dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String testPage() {
        return "test";
    }
}


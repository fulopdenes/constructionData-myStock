package com.constructionData.myStock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = {"http://192.168.0.17:3000", "http://localhost:3000"})
public class TestController {

    @GetMapping("/")
    public String statusCheck() {
        return "Working...";
    }
}

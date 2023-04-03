package com.example.chapter111.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController() {
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity
                .status(200)
                .header("Content-Type", "text/plain")
                .body("Hello World!");
    }
}

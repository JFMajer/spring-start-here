package com.example.chapter71.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // return page.html from static folder
    @GetMapping("/page")
    public String page() {
        return "page.html";
    }


}

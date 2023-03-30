package com.example.chapter81.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(
            @RequestParam String color,
            @RequestParam String username,
            Model page) {
        page.addAttribute("username", username);
        page.addAttribute("color", color);
        return "home.html";
    }

    @RequestMapping("/page/{color}")
    public String page(
            @PathVariable String color,
            Model page) {
        page.addAttribute("color", color);
        return "page.html";
    }
}

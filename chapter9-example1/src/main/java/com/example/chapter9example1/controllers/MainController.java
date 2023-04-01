package com.example.chapter9example1.controllers;

import com.example.chapter9example1.services.LoggedUserManagmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final LoggedUserManagmentService loggedUserManagmentService;

    public MainController(LoggedUserManagmentService loggedUserManagmentService) {
        this.loggedUserManagmentService = loggedUserManagmentService;
    }

    @GetMapping("/main")
    public String main(Model model) {
        String username = loggedUserManagmentService.getUsername();
        if (username == null) {
            return "redirect:/";
        }
        model.addAttribute("username", username);
        return "main.html";
    }

    @PostMapping("/logout")
    public String logout() {
        loggedUserManagmentService.setUsername(null);
        return "redirect:/";
    }
}



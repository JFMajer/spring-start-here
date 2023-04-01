package com.example.chapter9example1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.chapter9example1.processors.LoginProcessor;

@Controller
public class LoginController {

    private final LoginProcessor lp;

    public LoginController(LoginProcessor lp) {
        this.lp = lp;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        lp.setUsername(username);
        lp.setPassword(password);
        boolean loggedIn = lp.login();

        if (loggedIn) {
            model.addAttribute("message", "You are logged in!");
            return "redirect:/main";
        } else {
            model.addAttribute("message", "You are not logged in!");
        }
        model.addAttribute("message", "authentication failed");
        return "login.html";
    }

}

package com.example.chapter9example1.processors;

import com.example.chapter9example1.services.LoggedUserManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagmentService loggedUserManagmentService;

    private String username;
    private String password;

    @Autowired
    public LoginProcessor(LoggedUserManagmentService loggedUserManagmentService) {
        this.loggedUserManagmentService = loggedUserManagmentService;
    }

    public boolean login() {

        if (username.equals("admin") && password.equals("admin")) {
            loggedUserManagmentService.setUsername(username);
            return true;
        } else {
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

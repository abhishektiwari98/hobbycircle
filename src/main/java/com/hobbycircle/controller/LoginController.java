package com.hobbycircle.controller;

import com.hobbycircle.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private static String VALID_EMAIL = "ramayan@me.com";
    private static String VALID_PASSWORD = "test1234";

    @PostMapping("/login")
    public String login(Model model,
                        @RequestParam(name = "email") String email,
                        @RequestParam(name = "pwd") String password) {
        if (VALID_EMAIL.equals(email) && VALID_PASSWORD.equals(password)) {
            return "redirect:/home";
        } else {
            return "redirect:/";
        }
    }
}

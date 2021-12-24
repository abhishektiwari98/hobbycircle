package com.hobbycircle.controller;

import com.hobbycircle.common.Constants;
import com.hobbycircle.common.InMemoryUserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    InMemoryUserStore store;

    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");

        boolean result = store.isUserValid(email, password);

        if (result) {
            // setting the session param
            request.getSession().setAttribute(Constants.SESSION_AUTH_KEY, true);

            return "redirect:/home";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}

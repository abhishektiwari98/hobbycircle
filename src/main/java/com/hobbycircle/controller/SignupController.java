package com.hobbycircle.controller;

import com.hobbycircle.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
    @PostMapping("/register")
    public String register() {
        return Constants.INDEX_PAGE_VIEW_NAME;
    }
}

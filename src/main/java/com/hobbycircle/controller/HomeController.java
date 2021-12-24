package com.hobbycircle.controller;

import com.hobbycircle.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Home page for both logged in and guest users.
 */
@Controller
public class HomeController {

    /**
     * Handles guest users, who visit the home page.
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return Constants.INDEX_PAGE_VIEW_NAME;
    }

    /**
     * Handles authenticated/logged-in users.
     * @return
     */
    @RequestMapping("/home")
    public String home() {
        return Constants.HOME_PAGE_VIEW_NAME;
    }
}

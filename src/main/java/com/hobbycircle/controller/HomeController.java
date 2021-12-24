package com.hobbycircle.controller;

import com.hobbycircle.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


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
    public String home(HttpServletRequest request) {
        Object value = request.getSession().getAttribute(Constants.SESSION_AUTH_KEY);
        if (value == null) {
            return "redirect:/";
        }

        return Constants.HOME_PAGE_VIEW_NAME;
    }
}

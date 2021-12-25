package com.hobbycircle.controller;

import com.hobbycircle.common.Constants;
import com.hobbycircle.common.InMemoryUserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller to handle user login requests.
 */
@Controller
public class LoginController {
    @Autowired
    InMemoryUserStore store;

    /**
     * Handles the login endpoint.
     * @param model the UI model passed down to the templating engine.
     * @param request HTTP request from the user.
     * @return string representing the name of the view in templates.
     */
    @PostMapping(Constants.LOGIN_ENDPOINT)
    public String login(Model model, HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");

        boolean result = store.isUserValid(email, password);

        if (result) {
            // setting the session param
            request.getSession().setAttribute(Constants.SESSION_AUTH_KEY, true);

            return Constants.HOME_REDIRECT;
        } else {
            return Constants.INDEX_REDIRECT;
        }
    }

    @RequestMapping(Constants.LOGOUT_ENDPOINT)
    public String logout(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        return Constants.INDEX_REDIRECT;
    }
}

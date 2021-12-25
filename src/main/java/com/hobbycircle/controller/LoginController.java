package com.hobbycircle.controller;

import com.google.common.base.Preconditions;
import com.hobbycircle.common.Constants;
import com.hobbycircle.common.Utils;
import com.hobbycircle.model.User;
import com.hobbycircle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Controller to handle user login requests.
 */
@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

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

        Preconditions.checkArgument(email != null && !email.isEmpty());
        Preconditions.checkArgument(password != null && !password.isEmpty());

        Optional<User> dbResult = userRepository.findById(email);
        if (dbResult.isPresent()) {
            User user = dbResult.get();
            String storedPass = user.getPassword();
            String encryptedPassword = Utils.getPasswordHash(password);

            if (storedPass.equals(encryptedPassword)) {
                // setting the session param
                request.getSession().setAttribute(Constants.SESSION_AUTH_KEY, true);

                return Constants.HOME_REDIRECT;
            }
        }

        return Constants.INDEX_REDIRECT;
    }

    @RequestMapping(Constants.LOGOUT_ENDPOINT)
    public String logout(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        return Constants.INDEX_REDIRECT;
    }
}

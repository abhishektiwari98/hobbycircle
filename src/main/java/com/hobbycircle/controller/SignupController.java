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

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignupController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(Constants.REGISTER_ENDPOINT)
    public String register(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String confirmPwd = request.getParameter("cnfpwd");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        if (!validateRequest(name, pwd, confirmPwd, email, city, country)) {
            return Constants.INDEX_REDIRECT;
        }

        String encryptedPass = Utils.getPasswordHash(pwd);
        User user = new User(name, email, city, country, encryptedPass);
        userRepository.save(user);

        return Constants.INDEX_PAGE_VIEW_NAME;
    }

    private boolean validateRequest(String name, String pwd, String cnfPwd, String email, String city, String country) {
        try {
            Preconditions.checkArgument(name != null && !name.isEmpty());
            Preconditions.checkArgument(pwd != null && !pwd.isEmpty());
            Preconditions.checkArgument(cnfPwd != null && !cnfPwd.isEmpty());
            Preconditions.checkArgument(email != null && !email.isEmpty());
            Preconditions.checkArgument(city != null && !city.isEmpty());
            Preconditions.checkArgument(country != null && !country.isEmpty());

            Preconditions.checkArgument(pwd.equals(cnfPwd));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

package com.hobbycircle.controller;

import com.hobbycircle.common.Constants;
import com.hobbycircle.common.InMemoryUserStore;
import com.hobbycircle.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignupController {
    @Autowired
    InMemoryUserStore store;

    @PostMapping(Constants.REGISTER_ENDPOINT)
    public String register(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String confirmPwd = request.getParameter("cnfpwd");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        if (name == null || name.isEmpty() || email == null || email.isEmpty() || !pwd.equals(confirmPwd)) {
            return Constants.INDEX_REDIRECT;
        }

        User user = new User(name, email, city, country, pwd);
        store.addNewUser(user);

        return Constants.INDEX_PAGE_VIEW_NAME;
    }
}

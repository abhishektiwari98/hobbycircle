package com.hobbycircle.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * In memory store to store user information.
 */
@Component
public class InMemoryUserStore {
    final Map<String, User> emailToUserDetails;

    public InMemoryUserStore() {
        this.emailToUserDetails = new HashMap<>();
    }

    /**
     * Adds a new user detail to the in-memory data store.
     * @param request
     */
    public void addNewUser(final User request) {
        if (request == null) {
            return;
        }

        emailToUserDetails.put(request.getEmail(), request);
    }

    public boolean isUserValid(final String email, final String pass) {
        User detail = emailToUserDetails.get(email);
        if (detail == null) {
            return false;
        }

        String storedPassword = detail.getPwd();
        return storedPassword.equals(pass);
    }
}

package com.hobbycircle.common;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * Common utilities for the overall application.
 */
public class Utils {

    /**
     * Encrypts the user password using SHA256.
     *
     * @param password user password in plaintext
     * @return encrypted password
     */
    public static String getPasswordHash(final String password) {
        String sha256hex = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }
}

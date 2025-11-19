package com.example.demo.core.domain.service;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Component
public class PasswordHasher {

    public String hash(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public boolean matches(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
package com.example.demo.core.domain.service;

public interface PasswordHasher {
    
    String hash(String plainPassword);

    boolean verify(String plainPassword, String hashedPassword);
}
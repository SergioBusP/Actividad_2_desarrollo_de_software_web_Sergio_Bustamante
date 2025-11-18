package com.core.domain.service;

public interface PasswordHasher {
    String hash(String plain);
}
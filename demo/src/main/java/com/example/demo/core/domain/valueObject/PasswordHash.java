package com.core.domain.valueObject;

import org.springframework.security.crypto.bcrypt.BCrypt;

public record PasswordHash(String value) {

    public static PasswordHash from(String hash) {
        return new PasswordHash(hash);
    }

    public boolean verify(String plain) {
        return BCrypt.checkpw(plain, value);
    }
}
package com.example.demo.core.domain.service;

import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.exception.PasswordDebilException;

@Service
public class PasswordStrengthEvaluator {

    private static final Pattern UPPERCASE = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE = Pattern.compile(".*[a-z].*");
    private static final Pattern DIGIT = Pattern.compile(".*\\d.*");
    private static final Pattern SPECIAL = Pattern.compile(".*[!@#$%^&*()_+\\-=\\[\\]{};:'\"|,.<>/?].*");
    private static final Pattern WHITESPACE = Pattern.compile(".*\\s.*");

    // Lista corta de passwords prohibidas (puedes extenderla)
    private static final Set<String> COMMON_WEAK_PASSWORDS = Set.of(
            "123456",
            "password",
            "123456789",
            "qwerty",
            "abc123",
            "111111",
            "12345678",
            "admin",
            "1234",
            "iloveyou"
    );

    public void validate(String password) {

        if (password == null || password.isBlank()) {
            throw new PasswordDebilException("La contraseña no puede estar vacía.");
        }

        if (password.length() < 8) {
            throw new PasswordDebilException("La contraseña debe tener al menos 8 caracteres.");
        }

        if (WHITESPACE.matcher(password).matches()) {
            throw new PasswordDebilException("La contraseña no puede contener espacios.");
        }

        if (!UPPERCASE.matcher(password).matches()) {
            throw new PasswordDebilException("Debe contener al menos una letra mayúscula.");
        }

        if (!LOWERCASE.matcher(password).matches()) {
            throw new PasswordDebilException("Debe contener al menos una letra minúscula.");
        }

        if (!DIGIT.matcher(password).matches()) {
            throw new PasswordDebilException("Debe contener al menos un número.");
        }

        if (!SPECIAL.matcher(password).matches()) {
            throw new PasswordDebilException("Debe contener al menos un caracter especial.");
        }

        if (COMMON_WEAK_PASSWORDS.contains(password.toLowerCase())) {
            throw new PasswordDebilException("La contraseña es demasiado común o insegura.");
        }
    }
}

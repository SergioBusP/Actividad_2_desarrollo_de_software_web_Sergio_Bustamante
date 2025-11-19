package com.example.demo.core.domain.valueObject;

import jakarta.persistence.Embeddable;

@Embeddable
public class PasswordHash {

    private String value;

    public PasswordHash() {}

    public PasswordHash(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
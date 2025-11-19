package com.example.demo.core.domain.entity;

import java.time.LocalDateTime;

public class Session {

    private Long id;
    private Long userId;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    public Session() {
    }

    public Session(Long id, Long userId, String token, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.id = id;
        this.userId = userId;
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    // Constructor sin ID, útil para sesiones nuevas
    public Session(Long userId, String token, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.userId = userId;
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                '}';
    }
}

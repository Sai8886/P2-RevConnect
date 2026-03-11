package com.example.revconnect.dto;

public class LoginResponse {

    private Long userId;
    private String userName;
    private String email;

    public LoginResponse() {}

    public LoginResponse(Long userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
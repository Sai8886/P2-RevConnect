package com.example.revconnect.dto;

import com.example.revconnect.entity.User;

public class UserSearchResponse {

    private Long userId;
    private String userName;
    private String email;
    private String accountType;
    private Boolean isPrivate;

    // Empty constructor
    public UserSearchResponse() {}

    // Constructor used in service
    public UserSearchResponse(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.accountType = user.getAccountType().name();
        this.isPrivate = user.getIsPrivate();
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}
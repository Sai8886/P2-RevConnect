package com.example.revconnect.dto;

import com.example.revconnect.entity.AccountType;
import com.example.revconnect.entity.SecurityQuestion;

public class RegisterRequest {

    private String userName;
    private String email;
    private String password;
    private AccountType accountType;
    private SecurityQuestion securityQuestion;
    private String securityAnswer;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public AccountType getAccountType() { return accountType; }
    public void setAccountType(AccountType accountType) { this.accountType = accountType; }

    public SecurityQuestion getSecurityQuestion() { return securityQuestion; }
    public void setSecurityQuestion(SecurityQuestion securityQuestion) { this.securityQuestion = securityQuestion; }

    public String getSecurityAnswer() { return securityAnswer; }
    public void setSecurityAnswer(String securityAnswer) { this.securityAnswer = securityAnswer; }
}
package com.example.revconnect.entity;

public enum SecurityQuestion {

    FIRST_SCHOOL("What is your first school name?"),
    MOTHER_MAIDEN_NAME("What is your mother's maiden name?"),
    FAVORITE_FOOD("What is your favorite food?"),
    BIRTH_CITY("What city were you born in?"),
    CHILDHOOD_NICKNAME("What was your childhood nickname?");

    private final String question;

    SecurityQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}
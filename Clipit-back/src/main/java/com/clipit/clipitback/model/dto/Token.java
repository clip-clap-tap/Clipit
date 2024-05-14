package com.clipit.clipitback.model.dto;

public class Token {
    private String userId;
    private int exp;

    public Token() {
    }

    public Token(String userId, int exp) {
        this.userId = userId;
        this.exp = exp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Token{" +
                "userId='" + userId + '\'' +
                ", exp=" + exp +
                '}';
    }
}

package com.workintech.twitter.demo.dto;

public class LoginResponse extends ResponseBase{
    private String token;
    public LoginResponse(String token, boolean isSuccess, String errorMessage) {
        super(isSuccess, errorMessage);
    }
}

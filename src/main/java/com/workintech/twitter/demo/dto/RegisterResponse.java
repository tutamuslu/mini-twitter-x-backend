package com.workintech.twitter.demo.dto;

import com.workintech.twitter.demo.entity.User;

public class RegisterResponse extends ResponseBase {
    private User user;

    public RegisterResponse(User user, boolean isSuccess, String errorMessage) {
        super(isSuccess, errorMessage);
    }
}

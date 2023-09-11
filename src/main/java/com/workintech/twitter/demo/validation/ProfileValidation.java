package com.workintech.twitter.demo.validation;

import com.workintech.twitter.demo.dto.LoginRequest;
import com.workintech.twitter.demo.dto.LoginResponse;
import com.workintech.twitter.demo.dto.RegisterResponse;
import com.workintech.twitter.demo.entity.User;

public class ProfileValidation {
    public static RegisterResponse validateRegister(User user){
        if(user == null){
            return new RegisterResponse(null, false, "User bilgisi null olamaz");
        }
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            return new RegisterResponse(null, false, "Kullanıcı adı boş olamaz");
        }
        if(user.getEmail() == null || user.getEmail().isEmpty()){
            return new RegisterResponse(null, false, "Email adı boş olamaz");
        }
        if(user.getFullName() == null || user.getFullName().isEmpty()){
            return new RegisterResponse(null, false, "Kullanıcı ismi adı boş olamaz");
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            return new RegisterResponse(null, false, "Şifre adı boş olamaz");
        }
        return null;
    }

    public static LoginResponse validateLogin(LoginRequest loginRequest){
        if(loginRequest == null){
            return new LoginResponse("", false, "Login inputu null olamaz");
        }
        if(loginRequest.getUser() == null || loginRequest.getUser().isEmpty()){
            return new LoginResponse("", false, "Kullanıcı adı girilmelidir!");
        }
        if(loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()){
            return  new LoginResponse("", false, "Şifre girilmelidir!");
        }
        return null
                ;
    }
}

package com.workintech.twitter.demo.controller;

import com.workintech.twitter.demo.dto.LoginRequest;
import com.workintech.twitter.demo.dto.LoginResponse;
import com.workintech.twitter.demo.dto.RegisterResponse;
import com.workintech.twitter.demo.entity.User;
import com.workintech.twitter.demo.service.ProfileService;
import com.workintech.twitter.demo.validation.ProfileValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private ProfileService profileService;
    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody User user){
        // genel validasyon
        RegisterResponse validation = ProfileValidation.validateRegister(user);
        if(validation != null){
            return validation;
        }
        // kullanıcı adı daha önce kullanılmış mı?
        String deneme = user.getUsername();
        Optional<User> isRegistered = profileService.findByUserName(deneme);
        if(isRegistered.isPresent()){
            return new RegisterResponse(null, false, "Kullanıcı adı zaten kullanılmaktadır!");
        }
        user.setRegisterDate(new Date());
        profileService.register(user);
        return new RegisterResponse(user, true, "");
    }

    @PostMapping("/logout")
    public void logout(){

    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        LoginResponse validate = ProfileValidation.validateLogin(loginRequest);
        if(validate != null){
            return validate;
        }
        Optional<User> user = profileService.findByUserName(loginRequest.getUser());
        if(!user.isPresent()){
            return new LoginResponse("", false, "Kullanıcı sistemde bulunamadı!");
        }
        User loginUser = profileService.login(loginRequest.getUser(), loginRequest.getPassword());
        if(loginUser == null){
            return  new LoginResponse("", false, "Kullanıcı adı veya şifre yanlış girildi!");
        }
        return new LoginResponse("asdsad", true, "");
    }
}

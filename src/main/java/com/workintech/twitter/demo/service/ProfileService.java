package com.workintech.twitter.demo.service;

import com.workintech.twitter.demo.entity.User;

import java.util.Optional;

public interface ProfileService {
    Optional<User> findByUserName(String userName);
    User register(User user);
    User logout(int id);
    User login(String userName, String password);
}

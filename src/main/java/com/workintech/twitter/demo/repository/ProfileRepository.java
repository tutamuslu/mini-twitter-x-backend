package com.workintech.twitter.demo.repository;

import com.workintech.twitter.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<User, Integer> {

    @Query("SELECT a FROM User a WHERE a.userName = :userName")
    Optional<User> findByUserName(String userName);

}

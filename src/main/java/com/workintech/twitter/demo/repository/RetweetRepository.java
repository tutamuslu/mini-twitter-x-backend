package com.workintech.twitter.demo.repository;

import com.workintech.twitter.demo.entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetweetRepository extends JpaRepository<Retweet, Integer> {
}

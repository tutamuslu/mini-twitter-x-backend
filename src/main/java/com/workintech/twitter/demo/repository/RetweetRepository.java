package com.workintech.twitter.demo.repository;

import com.workintech.twitter.demo.entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RetweetRepository extends JpaRepository<Retweet, Integer> {

    //@Query("delete from Retweet a where a.tweetId = :tweetId")
    //int deleteByTweetId(int tweetId);
}

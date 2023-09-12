package com.workintech.twitter.demo.repository;

import com.workintech.twitter.demo.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    //@Query("delete from Like a where a.tweetId = :tweetId")
    //int deleteByTweetId(int tweetId);
}

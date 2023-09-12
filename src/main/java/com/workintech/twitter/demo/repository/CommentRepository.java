package com.workintech.twitter.demo.repository;

import com.workintech.twitter.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    //@Query("delete from Comment a where a.tweetId = :tweetId")
    //int deleteByTweetId(int tweetId);
}

package com.workintech.twitter.demo.service;

import com.workintech.twitter.demo.dto.TweetResponse;
import com.workintech.twitter.demo.entity.Comment;
import com.workintech.twitter.demo.entity.Tweet;

import java.util.List;
import java.util.Optional;

public interface TweetService {
    List<Tweet> getAll();
    Optional<Tweet> getById(int id);
    Tweet newTweet(Tweet tweet);
    TweetResponse update(int id, Tweet tweet);
    TweetResponse delete(int id);
    TweetResponse like(int id);
    TweetResponse unLike(int id);
    TweetResponse retweet(int id);
    TweetResponse newComment(int id, Comment comment);
    TweetResponse deleteComment(int id);
}

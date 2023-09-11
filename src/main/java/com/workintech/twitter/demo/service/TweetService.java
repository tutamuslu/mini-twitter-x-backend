package com.workintech.twitter.demo.service;

import com.workintech.twitter.demo.entity.Comment;
import com.workintech.twitter.demo.entity.Tweet;

import java.util.List;

public interface TweetService {
    List<Tweet> getAll();
    Tweet getById(int id);
    Tweet newTweet(Tweet tweet);
    Tweet update(Tweet tweet);
    Tweet like(int id);
    Tweet unLike(int id);
    Tweet retweet(int id);
    Tweet newComment(int id, Comment comment);
    Tweet deleteComment(int id);
}

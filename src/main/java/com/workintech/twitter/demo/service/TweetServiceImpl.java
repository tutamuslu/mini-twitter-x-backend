package com.workintech.twitter.demo.service;

import com.workintech.twitter.demo.entity.Comment;
import com.workintech.twitter.demo.entity.Tweet;
import com.workintech.twitter.demo.repository.CommentRepository;
import com.workintech.twitter.demo.repository.TweetRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class TweetServiceImpl implements TweetService{

    private TweetRepository tweetRepository;
    private CommentRepository commentRepository;

    public TweetServiceImpl(TweetRepository tweetRepository, CommentRepository commentRepository){
        this.tweetRepository = tweetRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Tweet> getAll() {
        return tweetRepository.findAll();
    }

    @Override
    public Tweet getById(int id) {
        return tweetRepository.findById(id).get();
    }

    @Override
    public Tweet newTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet update(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet like(int id) {
return null
        ;
    }

    @Override
    public Tweet unLike(int id) {
        return null;
    }

    @Override
    public Tweet retweet(int id) {
        return null;
    }

    @Override
    public Tweet newComment(int id, Comment comment) {
        return null;
    }

    @Override
    public Tweet deleteComment(int id) {
        return null;
    }
}

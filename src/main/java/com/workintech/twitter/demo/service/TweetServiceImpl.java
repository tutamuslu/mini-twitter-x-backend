package com.workintech.twitter.demo.service;

import com.workintech.twitter.demo.dto.TweetResponse;
import com.workintech.twitter.demo.entity.*;
import com.workintech.twitter.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService{

    private TweetRepository tweetRepository;
    private CommentRepository commentRepository;
    private LikeRepository likeRepository;
    private RetweetRepository retweetRepository;
    private MemberRepository memberRepository;

    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository, CommentRepository commentRepository, LikeRepository likeRepository, RetweetRepository retweetRepository, MemberRepository memberRepository){
        this.tweetRepository = tweetRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
        this.retweetRepository = retweetRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Tweet> getAll() {

        return tweetRepository.findAll();
    }

    @Override
    public Optional<Tweet> getById(int id) {
        return tweetRepository.findById(id);
    }

    @Override
    public Tweet newTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public TweetResponse update(int id, Tweet tweet) {
        Optional<Tweet> tweet1 = tweetRepository.findById(id);
        if(tweet1.isPresent()){
            tweet1.get().setContent(tweet.getContent());
            Tweet tweet2 = tweetRepository.save(tweet);
            return new TweetResponse(tweet2, true, "");
        }
        else{
            return new TweetResponse(null, false, "Tweet bulunamadı!!");
        }

    }

    @Override
    public TweetResponse delete(int id) {
        Optional<Tweet> tweet = tweetRepository.findById(id);
        if(tweet.isPresent()){
            /*likeRepository.deleteByTweetId(tweet.get().getId());
            retweetRepository.deleteByTweetId(tweet.get().getId());
            commentRepository.deleteByTweetId(tweet.get().getId());*/
            tweetRepository.deleteById(id);
            return new TweetResponse(null , true, "");
        }
        return new TweetResponse(null, false, "Tweet Bulunamadı!");
    }

    @Override
    public TweetResponse like(int id) {
        Optional<Tweet> tweet = tweetRepository.findById(id);
        if(tweet.isPresent()){
            Optional<Member> member = memberRepository.findById(1);//tweet.get().getTweetUserId());
            if(member.isPresent()){
                Like newLike = new Like();
                newLike.setLikeDate(new Date());
                //newLike.setUserId(member.get());
                Like like = likeRepository.save(newLike);
                tweet.get().setLikeCount(tweet.get().getLikeCount() + 1);
                tweetRepository.save(tweet.get());
                return new TweetResponse(tweet.get(), true, "");
            }

        }
        return new TweetResponse(null, false, "Tweet silinemedi!");
    }

    @Override
    public TweetResponse unLike(int id) {
        return null;
    }

    @Override
    public TweetResponse retweet(int id) {
        return null;
    }

    @Override
    public TweetResponse newComment(int id, Comment comment) {
        return null;
    }

    @Override
    public TweetResponse deleteComment(int id) {
        return null;
    }
}

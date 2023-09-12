package com.workintech.twitter.demo.controller;

import com.workintech.twitter.demo.dto.TweetResponse;
import com.workintech.twitter.demo.entity.Comment;
import com.workintech.twitter.demo.entity.Tweet;
import com.workintech.twitter.demo.service.TweetService;
import com.workintech.twitter.demo.validation.TweetValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService){
        this.tweetService = tweetService;
    }
    @GetMapping("/")
    public List<Tweet> getAll(){
        return tweetService.getAll();
    }
    @GetMapping("/{id}")
    public TweetResponse getById(@PathVariable int id){
        TweetResponse idValidation = TweetValidation.controlId(id);
        if(idValidation != null){
            return idValidation;
        }
        Optional<Tweet> tweet = tweetService.getById(id);
        if(tweet.isPresent()){
            return  new TweetResponse(tweet.get(), true, "");
        }else{
            return new TweetResponse(null, false, "Tweet bulunamadı!");
        }
    }

    @PostMapping("/")
    public TweetResponse add(@RequestBody Tweet tweet){
        TweetResponse validate = TweetValidation.controlSave(tweet);
        if(validate != null){
            return validate;
        }
        Tweet tweet1 = tweetService.newTweet(tweet);
        if(tweet1 != null){
            return new TweetResponse(tweet1, true, "");
        }else{
            return new TweetResponse(null, false, "Tweet eklenemedi!!");
        }
    }

    @PutMapping("/{id}")
    public TweetResponse update(@PathVariable int id, @RequestBody Tweet tweet){
        TweetResponse idValidation = TweetValidation.controlId(id);
        if(idValidation != null){
            return idValidation;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public TweetResponse delete(@PathVariable int id){
        TweetResponse idValidation = TweetValidation.controlId(id);
        if(idValidation != null){
            return idValidation;
        }
        TweetResponse tweetResponse = tweetService.delete(id);
        return tweetResponse;
    }

    @PostMapping("/like/{id}")
    public void like(@PathVariable int id){

    }

    @DeleteMapping("/like/{id}")
    public void unLike(@PathVariable int id){

    }

    @PostMapping("/retweet/{id}")
    public void retweet(@PathVariable int id){

    }

    @PostMapping("/reply/{id}")
    public void addComment(@PathVariable int id, Comment comment){

    }

    @DeleteMapping("/reply/{id}")
    public void deleteComment(@PathVariable int id){

    }
}

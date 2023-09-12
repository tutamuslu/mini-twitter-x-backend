package com.workintech.twitter.demo.validation;

import com.workintech.twitter.demo.dto.TweetResponse;
import com.workintech.twitter.demo.entity.Tweet;

public class TweetValidation {
    public static TweetResponse controlId(int id){
        if(id <= 0){
            return new TweetResponse(null, false, "Id 1den küçük olamaz.");
        }
        return null;
    }
    public static TweetResponse controlSave(Tweet tweet){
        if(tweet.getContent() == null || tweet.getContent().isEmpty()){
            return new TweetResponse(null, false, "Tweet içeriği boş olamaz!");
        }
        if(tweet.getTweetDate() == null){
            return new TweetResponse(null, false, "Tweet tarihi boş olamaz!");
        }
        return null;
    }
}

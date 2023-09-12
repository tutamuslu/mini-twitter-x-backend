package com.workintech.twitter.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@Entity
@Table(name = "retweet", schema = "twitter_app")
public class Retweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //@Column(name = "tweet_id")
    //private int tweetId;

    //@Column(name = "user_id")
    //private int userId;

    @Column(name = "retweet_date")
    private Date retweetDate;
}

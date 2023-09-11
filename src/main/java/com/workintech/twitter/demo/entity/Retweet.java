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

    private int tweetId;

    private int userId;

    @Column(name = "retweet_date")
    private Date retweetDate;
}

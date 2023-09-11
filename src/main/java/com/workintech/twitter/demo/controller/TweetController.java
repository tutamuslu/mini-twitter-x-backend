package com.workintech.twitter.demo.controller;

import com.workintech.twitter.demo.entity.Comment;
import com.workintech.twitter.demo.entity.Tweet;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tweet")
public class TweetController {
    @GetMapping("/")
    public void getAll(){

    }
    @GetMapping("/{id}")
    public void getById(@PathVariable int id){

    }

    @PostMapping("/")
    public void add(@RequestBody Tweet tweet){

    }

    @PostMapping("/{id}")
    public void add(@PathVariable int id, @RequestBody Tweet tweet){

    }

    @DeleteMapping("/{id}")
    public void add(@PathVariable int id){

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

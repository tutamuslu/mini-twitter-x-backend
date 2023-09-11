package com.workintech.twitter.demo.repository;

import com.workintech.twitter.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

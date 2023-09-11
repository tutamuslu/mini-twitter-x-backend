package com.workintech.twitter.demo.repository;

import com.workintech.twitter.demo.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
}

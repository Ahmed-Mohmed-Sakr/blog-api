package com.bloging.blogapp.model;

import com.bloging.blogapp.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
}

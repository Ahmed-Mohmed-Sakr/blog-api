package com.bloging.blogapp.model;

import com.bloging.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Integer> {
}
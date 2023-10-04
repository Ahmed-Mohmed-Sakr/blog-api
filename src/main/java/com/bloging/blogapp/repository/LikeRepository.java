package com.bloging.blogapp.repository;

import com.bloging.blogapp.entity.Like;
import com.bloging.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    int countByPost(Post post);
}

package com.bloging.blogapp.repository;


import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface PostPagingAndSortingRepository extends PagingAndSortingRepository<Post, Integer> {
    Post save(Post post);
    
    boolean existsByUser(User user);

    Optional<Post> findById(int postId);

    void deleteById(int postId);
}

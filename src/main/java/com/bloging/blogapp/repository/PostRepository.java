package com.bloging.blogapp.repository;


import com.bloging.blogapp.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;



public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

    List<Post> findAllById(int id, Pageable pageable);
}

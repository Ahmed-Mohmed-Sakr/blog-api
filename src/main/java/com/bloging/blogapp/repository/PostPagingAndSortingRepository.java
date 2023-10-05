package com.bloging.blogapp.repository;


import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.Optional;


public interface PostPagingAndSortingRepository extends PagingAndSortingRepository<Post, Integer> {
    Post save(Post post);
    
    boolean existsByUser(User user);

    Optional<Post> findById(int postId);

    void deleteById(int postId);
}

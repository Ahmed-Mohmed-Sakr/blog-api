package com.bloging.blogapp.repository;

import com.bloging.blogapp.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer> {
    Comment save(Comment comment);

    Optional<Comment> findById(int commentId);

    void deleteById(int commentId);
}

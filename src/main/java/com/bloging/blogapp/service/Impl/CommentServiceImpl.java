package com.bloging.blogapp.service.Impl;

import com.bloging.blogapp.entity.Comment;
import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.exceptions.customexceptions.NotAuthToSeeResourseException;
import com.bloging.blogapp.exceptions.customexceptions.ResourceNotFoundException;
import com.bloging.blogapp.mapper.CommentMapper;
import com.bloging.blogapp.model.comment.CommentRequestModel;
import com.bloging.blogapp.model.comment.CommentResponseModel;
import com.bloging.blogapp.repository.CommentRepository;
import com.bloging.blogapp.repository.PostPagingAndSortingRepository;
import com.bloging.blogapp.repository.UserRepository;
import com.bloging.blogapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostPagingAndSortingRepository postRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentResponseModel> getAllPostComments(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));

        return post.getComments().stream()
                .map(commentMapper::toResponse).toList();
    }

    @Override
    public CommentResponseModel createNewComment(CommentRequestModel request, int postId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));


        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));

        Comment comment = commentRepository.save(
                commentMapper.toEntity(request,user, post)
        );

        return commentMapper.toResponse(comment);
    }

    @Override
    public CommentResponseModel updateMyCommentById(CommentRequestModel request, int commentId) {
        checkUserAuthToPerformCRUDOnComment(commentId);

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("That Comment Id " + commentId + " Is Not Found!"));

        comment.setContent(request.getContent());
        comment.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return commentMapper.toResponse(commentRepository.save(comment));
    }

    @Override
    public void deleteMyCommentById(int commentId) {
        checkUserAuthToPerformCRUDOnComment(commentId);

        commentRepository.deleteById(commentId);
    }

    private void checkUserAuthToPerformCRUDOnComment(int commentId){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("That Comment Id " + commentId + " Is Not Found!"));

        if(comment.getUser().getId() != user.getId())
            throw new NotAuthToSeeResourseException("You are Not Auth to Do That");
    }
}

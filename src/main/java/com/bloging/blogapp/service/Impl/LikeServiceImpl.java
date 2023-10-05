package com.bloging.blogapp.service.Impl;

import com.bloging.blogapp.entity.Like;
import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.exceptions.customexceptions.NotAuthToSeeResourseException;
import com.bloging.blogapp.exceptions.customexceptions.ResourceNotFoundException;
import com.bloging.blogapp.mapper.LikeMapper;
import com.bloging.blogapp.model.like.LikeResponseModel;
import com.bloging.blogapp.repository.LikeRepository;
import com.bloging.blogapp.repository.PostPagingAndSortingRepository;
import com.bloging.blogapp.repository.UserRepository;
import com.bloging.blogapp.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostPagingAndSortingRepository postRepository;
    private final LikeMapper likeMapper;
    @Override
    public List<LikeResponseModel> getAllPostLikess(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));

        return post.getLikes().stream()
                .map(likeMapper::toResponse).toList();
    }

    @Override
    public LikeResponseModel AddLikeToPost(int postId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        if(likeRepository.existsByUser(user)){
            throw new ResourceNotFoundException("You Already created like");
        }

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));


        Like like = Like.builder()
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .user(user)
                .post(post)
                .build();

        return likeMapper.toResponse(likeRepository.save(like));
    }

    @Override
    public void deleteMyLike(int likeId) {
        checkUserAuthToPerformDeleteToLike(likeId);

        likeRepository.deleteById(likeId);
    }

    private void checkUserAuthToPerformDeleteToLike(int likeId){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        Like like = likeRepository.findById(likeId)
                .orElseThrow(() -> new ResourceNotFoundException("That Like Id " + likeId + " Is Not Found!"));

        if(like.getUser().getId() != user.getId())
            throw new NotAuthToSeeResourseException("You are Not Auth to Do That");
    }
}

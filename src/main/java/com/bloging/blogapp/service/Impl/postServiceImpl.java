package com.bloging.blogapp.service.Impl;

import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.exceptions.customexceptions.NotAuthToSeeResourseException;
import com.bloging.blogapp.exceptions.customexceptions.ResourceNotFoundException;
import com.bloging.blogapp.mapper.PostMapper;
import com.bloging.blogapp.model.post.PostRequestModel;
import com.bloging.blogapp.model.post.PostResponseModel;
import com.bloging.blogapp.repository.PostPagingAndSortingRepository;
import com.bloging.blogapp.repository.UserRepository;
import com.bloging.blogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class postServiceImpl implements PostService {

    private final PostPagingAndSortingRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostResponseModel> getAllPosts(int page) {
        Pageable pageable = PageRequest.of(page , 10);
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.stream().map(postMapper::toResponse).toList();
    }

    @Override
    public List<PostResponseModel> getPostsByUserId(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Id " + userId + " Not Found!"));

        List<Post> posts = user.getPosts();

        return posts.stream().map(postMapper::toResponse).toList();
    }

    @Override
    public PostResponseModel createNewPost(PostRequestModel request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        Post post = postRepository.save(postMapper.toEntity(request, user));

        return postMapper.toResponse(post);
    }

    @Override
    public PostResponseModel updateMyPostById(PostRequestModel request, int postId) {
        checkUserAuthToPerformCRUDOnPost(postId);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setSummary(request.getSummary());
        post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return postMapper.toResponse(postRepository.save(post));
    }

    @Override
    public void deleteMyPostById(int postId) {
        checkUserAuthToPerformCRUDOnPost(postId);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));


        postRepository.deleteById(postId);
    }

    private void checkUserAuthToPerformCRUDOnPost(int postId){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));

        if(post.getUser().getId() != user.getId())
            throw new NotAuthToSeeResourseException("You are Not Auth to Do That");
    }
}

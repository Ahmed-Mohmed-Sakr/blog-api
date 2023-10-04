package com.bloging.blogapp.service.Impl;

import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.mapper.PostMapper;
import com.bloging.blogapp.model.post.PostRequestModel;
import com.bloging.blogapp.model.post.PostResponseModel;
import com.bloging.blogapp.repository.LikeRepository;
import com.bloging.blogapp.repository.PostRepository;
import com.bloging.blogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class postServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostResponseModel> getAllPosts(int page) {
        Pageable pageable = PageRequest.of(page , 10);
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.stream().map(postMapper::toResponse).toList();
    }

    @Override
    public List<PostResponseModel> getPostsByUserId(int userId, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        List<Post> posts = postRepository.findAllById(userId,pageable);


        return posts.stream().map(postMapper::toResponse).toList();
    }

    @Override
    public PostResponseModel createNewPost(PostRequestModel request) {
        return null;
    }

    @Override
    public PostResponseModel updateMyPostById(PostRequestModel request, int postId) {
        return null;
    }

    @Override
    public void deleteMyPostById(int postId) {

    }
}

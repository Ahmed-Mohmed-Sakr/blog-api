package com.bloging.blogapp.service;

import com.bloging.blogapp.model.post.PostRequestModel;
import com.bloging.blogapp.model.post.PostResponseModel;

import java.util.List;

public interface PostService {
    List<PostResponseModel> getAllPosts(int page);

    List<PostResponseModel> getPostsByUserId(int userId);

    PostResponseModel createNewPost(PostRequestModel request);

    PostResponseModel updateMyPostById(PostRequestModel request, int postId);

    void deleteMyPostById(int postId);
}

package com.bloging.blogapp.service;

import com.bloging.blogapp.model.like.LikeResponseModel;

import java.util.List;

public interface LikeService {
    LikeResponseModel AddLikeToPost(int postId);

    List<LikeResponseModel> getAllPostLikess(int postId);

    void deleteMyLike(int likeId);
}

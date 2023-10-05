package com.bloging.blogapp.service;

import com.bloging.blogapp.model.post.PostResponseModel;
import com.bloging.blogapp.model.tage.TagRequestModel;
import com.bloging.blogapp.model.tage.TagResponseModel;

import java.util.List;

public interface TagService {
    List<TagResponseModel> getAllTags();

    TagResponseModel createNewTag(TagRequestModel request);

    void addTagToPost(int postId, int tagId);

    List<PostResponseModel> getAllPostsWithTagId(int id);

    List<PostResponseModel> getAllPostsWithTagName(String name);
}

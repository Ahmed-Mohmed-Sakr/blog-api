package com.bloging.blogapp.mapper;

import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.model.post.PostResponseModel;

public interface PostMapper {

    PostResponseModel toResponse(Post post);

}

package com.bloging.blogapp.mapper;

import com.bloging.blogapp.entity.Tag;
import com.bloging.blogapp.model.tages.TagsResponseModel;

public interface TagMapper {
    TagsResponseModel toResponse(Tag tag);
}

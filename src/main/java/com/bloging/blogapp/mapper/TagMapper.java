package com.bloging.blogapp.mapper;

import com.bloging.blogapp.entity.Tag;
import com.bloging.blogapp.model.tage.TagRequestModel;
import com.bloging.blogapp.model.tage.TagResponseModel;

public interface TagMapper {
    TagResponseModel toResponse(Tag tag);

    Tag toEntity(TagRequestModel request);
}

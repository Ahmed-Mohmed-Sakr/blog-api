package com.bloging.blogapp.mapper.Impl;

import com.bloging.blogapp.entity.Tag;
import com.bloging.blogapp.mapper.TagMapper;
import com.bloging.blogapp.model.tages.TagsResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TagMapperImpl implements TagMapper {
    @Override
    public TagsResponseModel toResponse(Tag tag) {
        return TagsResponseModel
                .builder()
                .id(tag.getId())
                .name(tag.getName())
                .description(tag.getDescription())
                .build();
    }
}

package com.bloging.blogapp.mapper.Impl;

import com.bloging.blogapp.entity.Tag;
import com.bloging.blogapp.mapper.TagMapper;
import com.bloging.blogapp.model.tage.TagRequestModel;
import com.bloging.blogapp.model.tage.TagResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class TagMapperImpl implements TagMapper {
    @Override
    public TagResponseModel toResponse(Tag tag) {
        return TagResponseModel
                .builder()
                .id(tag.getId())
                .name(tag.getName())
                .description(tag.getDescription())
                .build();
    }

    @Override
    public Tag toEntity(TagRequestModel request) {
        return Tag.builder()
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}

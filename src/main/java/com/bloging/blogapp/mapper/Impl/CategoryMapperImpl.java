package com.bloging.blogapp.mapper.Impl;

import com.bloging.blogapp.entity.Category;
import com.bloging.blogapp.mapper.CategoryMapper;
import com.bloging.blogapp.model.category.CategoryRequestModel;
import com.bloging.blogapp.model.category.CategoryResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryResponseModel toResponse(Category category) {
        return CategoryResponseModel
                .builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    @Override
    public Category toEntity(CategoryRequestModel request) {
        return Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}

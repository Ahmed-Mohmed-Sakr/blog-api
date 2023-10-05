package com.bloging.blogapp.mapper;

import com.bloging.blogapp.entity.Category;
import com.bloging.blogapp.model.category.CategoryRequestModel;
import com.bloging.blogapp.model.category.CategoryResponseModel;


public interface CategoryMapper {
    CategoryResponseModel toResponse(Category category);

    Category toEntity(CategoryRequestModel request);
}

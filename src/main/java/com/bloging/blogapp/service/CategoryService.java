package com.bloging.blogapp.service;

import com.bloging.blogapp.model.category.CategoryRequestModel;
import com.bloging.blogapp.model.category.CategoryResponseModel;
import com.bloging.blogapp.model.post.PostResponseModel;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseModel> getAllcategories();

    CategoryResponseModel createNewCategory(CategoryRequestModel request);

    void addPostToCategory(int postId, int categoryId);

    List<PostResponseModel> getAllPostsWithCategoryId(int id);

    List<PostResponseModel> getAllPostsWithCategoryName(String name);
}

package com.bloging.blogapp.service.Impl;

import com.bloging.blogapp.entity.Category;
import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.exceptions.customexceptions.NotAuthToSeeResourseException;
import com.bloging.blogapp.exceptions.customexceptions.ResourceNotFoundException;
import com.bloging.blogapp.mapper.CategoryMapper;
import com.bloging.blogapp.mapper.PostMapper;
import com.bloging.blogapp.model.category.CategoryRequestModel;
import com.bloging.blogapp.model.category.CategoryResponseModel;
import com.bloging.blogapp.model.post.PostResponseModel;
import com.bloging.blogapp.repository.CategoryRepository;
import com.bloging.blogapp.repository.PostPagingAndSortingRepository;
import com.bloging.blogapp.repository.UserRepository;
import com.bloging.blogapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final PostPagingAndSortingRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseModel> getAllcategories() {
        return categoryRepository.findAll()
                .stream().map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponseModel createNewCategory(CategoryRequestModel request) {
        if(categoryRepository.existsByName(request.getName())){
            throw new NotAuthToSeeResourseException("That Category " + request.getName() + " Is Already exist!");
        }

        Category category = categoryMapper.toEntity(request);

        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public void addPostToCategory(int postId, int categoryId) {
        checkUserAuthToPerformCRUDOnPost(postId);

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("That Category Id " + categoryId + " Is Not Found!"));

        Post post = postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));

        if(post.getCategories().contains(category))
            throw new ResourceNotFoundException("That Category Contains that Post Already!");

        post.addCategory(category);

        postRepository.save(post);
    }

    @Override
    public List<PostResponseModel> getAllPostsWithCategoryId(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("That Category Id " + categoryId + " Is Not Found!"));

        return category.getPosts().stream()
                .map(postMapper::toResponse)
                .toList();

    }

    @Override
    public List<PostResponseModel> getAllPostsWithCategoryName(String categoryName) {
        Category category = categoryRepository.findByName(categoryName)
                .orElseThrow(()-> new ResourceNotFoundException("That Category Name " + categoryName + " Is Not Found!"));

        return category.getPosts().stream()
                .map(postMapper::toResponse)
                .toList();
    }

    private void checkUserAuthToPerformCRUDOnPost(int postId){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User Email " + email + " Not Found!"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));

        if(post.getUser().getId() != user.getId())
            throw new NotAuthToSeeResourseException("You are Not Auth to Do Add That Post To Any Category");
    }
}

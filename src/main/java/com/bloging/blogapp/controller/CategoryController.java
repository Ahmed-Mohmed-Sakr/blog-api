package com.bloging.blogapp.controller;

import com.bloging.blogapp.model.category.CategoryRequestModel;
import com.bloging.blogapp.model.category.CategoryResponseModel;
import com.bloging.blogapp.model.post.PostResponseModel;
import com.bloging.blogapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<CategoryResponseModel> getAllcategories(){
        return categoryService.getAllcategories();
    }

    @PostMapping()
    public CategoryResponseModel createNewCategory(@RequestBody CategoryRequestModel request){
        return categoryService.createNewCategory(request);
    }

    @PostMapping("/{postId}/{categoryId}")
    public void addPostToCategory(
            @PathVariable int postId,
            @PathVariable int categoryId
    ){
        categoryService.addPostToCategory(postId, categoryId);
    }

    @GetMapping(params = "id")
    public List<PostResponseModel> getAllPostsWithCategoryId(@RequestParam(name = "id")int id){
        return categoryService.getAllPostsWithCategoryId(id);
    }

    @GetMapping(params = "name")
    public List<PostResponseModel> getAllPostsWithCategoryName(@RequestParam(name = "name")String name){
        return categoryService.getAllPostsWithCategoryName(name);
    }

}

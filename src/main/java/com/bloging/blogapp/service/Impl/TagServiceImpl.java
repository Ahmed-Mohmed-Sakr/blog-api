package com.bloging.blogapp.service.Impl;

import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.Tag;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.exceptions.customexceptions.NotAuthToSeeResourseException;
import com.bloging.blogapp.exceptions.customexceptions.ResourceNotFoundException;
import com.bloging.blogapp.mapper.PostMapper;
import com.bloging.blogapp.mapper.TagMapper;
import com.bloging.blogapp.model.post.PostResponseModel;
import com.bloging.blogapp.model.tage.TagRequestModel;
import com.bloging.blogapp.model.tage.TagResponseModel;
import com.bloging.blogapp.repository.PostPagingAndSortingRepository;
import com.bloging.blogapp.repository.TagRepository;
import com.bloging.blogapp.repository.UserRepository;
import com.bloging.blogapp.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    
    private final TagRepository tagRepository;
    private final PostPagingAndSortingRepository postRepository;
    private final UserRepository userRepository;
    private final TagMapper tagMapper;
    private final PostMapper postMapper;
    
    @Override
    public List<TagResponseModel> getAllTags() {
        return tagRepository.findAll()
                .stream().map(tagMapper::toResponse)
                .toList();
    }

    @Override
    public TagResponseModel createNewTag(TagRequestModel request) {
        if(tagRepository.existsByName(request.getName())){
            throw new NotAuthToSeeResourseException("That Tag " + request.getName() + " Is Already exist!");
        }

        Tag tag = tagMapper.toEntity(request);
        
        return tagMapper.toResponse(tagRepository.save(tag));
    }

    @Override
    public void addTagToPost(int postId, int tagId) {
        checkUserAuthToPerformCRUDOnPost(postId);

        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(()->new ResourceNotFoundException("That Tag Id " + tagId + " Is Not Found!"));

        Post post = postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("That Post Id " + postId + " Is Not Found!"));

        if(post.getTags().contains(tag))
            throw new ResourceNotFoundException("That post Contains that Tag Already!");

        post.addTag(tag);
        postRepository.save(post);
    }

    @Override
    public List<PostResponseModel> getAllPostsWithTagId(int tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(()->new ResourceNotFoundException("That Tag Id " + tagId + " Is Not Found!"));

        return tag.getPosts().stream()
                .map(postMapper::toResponse)
                .toList();
    }

    @Override
    public List<PostResponseModel> getAllPostsWithTagName(String tagName) {
        Tag tag = tagRepository.findByName(tagName)
                .orElseThrow(()-> new ResourceNotFoundException("That Tag Name " + tagName + " Is Not Found!"));

        return tag.getPosts().stream()
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
            throw new NotAuthToSeeResourseException("You are Not Auth to Do Add Tag To That Post");
    }
}

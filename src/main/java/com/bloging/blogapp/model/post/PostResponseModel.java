package com.bloging.blogapp.model.post;

import com.bloging.blogapp.model.tages.TagsResponseModel;
import com.bloging.blogapp.model.user.UserResponseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseModel {
    private int id;
    private String title;
    private String content;
    private String summary;
    private Timestamp updatedAt;
    private Timestamp publishedAt;
    private int LikesCount;
    private UserResponseModel Author;
    private List<TagsResponseModel> tags;
}

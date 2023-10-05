package com.bloging.blogapp.model.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseModel {
    private int id;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

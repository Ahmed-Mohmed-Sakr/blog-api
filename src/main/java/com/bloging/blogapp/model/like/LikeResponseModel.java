package com.bloging.blogapp.model.like;

import com.bloging.blogapp.model.user.UserResponseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponseModel {
    private int id;
    private Timestamp createdAt;
    private UserResponseModel user;

}

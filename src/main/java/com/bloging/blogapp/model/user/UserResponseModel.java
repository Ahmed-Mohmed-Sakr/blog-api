package com.bloging.blogapp.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

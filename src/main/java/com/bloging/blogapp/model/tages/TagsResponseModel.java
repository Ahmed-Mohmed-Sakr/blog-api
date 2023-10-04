package com.bloging.blogapp.model.tages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagsResponseModel {
    private int id;
    private String name;
    private String description;
}

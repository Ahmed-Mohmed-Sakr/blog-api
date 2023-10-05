package com.bloging.blogapp.model.tage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagResponseModel {
    private int id;
    private String name;
    private String description;
}

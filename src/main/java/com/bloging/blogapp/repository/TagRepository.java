package com.bloging.blogapp.repository;

import com.bloging.blogapp.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}

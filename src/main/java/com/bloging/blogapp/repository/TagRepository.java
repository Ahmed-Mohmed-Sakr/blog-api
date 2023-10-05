package com.bloging.blogapp.repository;

import com.bloging.blogapp.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    Optional<Tag> findByName(String tagName);

    boolean existsByName(String name);
}

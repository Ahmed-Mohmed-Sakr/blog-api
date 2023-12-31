package com.bloging.blogapp.repository;

import com.bloging.blogapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByName(String categoryName);

    boolean existsByName(String name);
}

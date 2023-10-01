package com.bloging.blogapp.model;

import com.bloging.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

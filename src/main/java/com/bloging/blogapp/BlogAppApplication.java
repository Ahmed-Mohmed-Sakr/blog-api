package com.bloging.blogapp;

import com.bloging.blogapp.entity.Post;
import com.bloging.blogapp.entity.User;
import com.bloging.blogapp.model.PostRepository;
import com.bloging.blogapp.model.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.sql.Timestamp;

@SpringBootApplication
public class BlogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args);
    }

    /**
     * create commandLineRunner for test purpose before move to real code
     * and make sure that entities are well config
    */
    @Bean
    public CommandLineRunner commandLineRunner(UserRepository  userRepository , PostRepository postRepository){
        return runner -> {
        };
    }


}

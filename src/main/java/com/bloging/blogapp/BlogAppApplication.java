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
     *
     * and make sure that entities are well config
    */

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository  userRepository , PostRepository postRepository){
        return runner -> {
//            addSomepostesToUser(postRepository, userRepository);
//            deletePost(postRepository);
            deleteUser(userRepository);
        };
    }

    private void deleteUser(UserRepository userRepository) {
        userRepository.deleteById(5);
    }

    private void deletePost(PostRepository postRepository) {
        postRepository.deleteById(4);
    }

    private void addSomepostesToUser(PostRepository postRepository, UserRepository userRepository) {

        Post post = Post.builder()
                .title("life")
                .content("life is lopjabjndbjbnjn jdbkjjdfbd")
                .summary("life story")
                .publishedAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        User user=
                User.builder()
                        .username("ali")
                        .email("aliSakr@gmail.com")
                        .password("kfbjbzgjnzdjb")
                        .createdAt(new Timestamp(System.currentTimeMillis()))
                        .updatedAt(new Timestamp(System.currentTimeMillis()))
                        .build();

        user.addPost(post);

        userRepository.save(user);
        System.out.println("user saved ");

    }

}

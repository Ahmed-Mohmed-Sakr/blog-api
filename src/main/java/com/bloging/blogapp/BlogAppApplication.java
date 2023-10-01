package com.bloging.blogapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    public CommandLineRunner commandLineRunner(){
        return runner -> {

        };
    }

}

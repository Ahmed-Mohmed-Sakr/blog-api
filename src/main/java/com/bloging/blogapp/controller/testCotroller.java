package com.bloging.blogapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class testCotroller {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello rom secured endpoint");
    }
}

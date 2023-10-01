package com.bloging.blogapp.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", nullable = false, length = -1)
    private String content;

    @Column(name = "summary", nullable = false, length = -1)
    private String summary;

    @Column(name = "author_id", nullable = false)
    private int authorId;

    @Column(name = "published_at", nullable = false)
    private Timestamp publishedAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

}

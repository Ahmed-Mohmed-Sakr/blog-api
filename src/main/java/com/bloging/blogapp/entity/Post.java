package com.bloging.blogapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "published_at", nullable = false)
    private Timestamp publishedAt;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
                        CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private  User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Like> likes;

}

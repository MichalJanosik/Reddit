package com.example.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateCreated;

    private Long voting;

    @ManyToOne
    private User user;

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public Post(String content) {
        this.title = content;
        this.voting = 0L;
    }

    public Post(String content, String url) {
        this(content);
        this.url = url;
    }
}

package com.example.reddit.service;

import com.example.reddit.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PostService {
    Page<Post> findAll(Pageable pageable);
    void saveAll(List<Post> posts);
    void savePost(Post post);
    void voteNegative(Post post);
    void votePositive(Post post);
    Post findById(Long id);
}

package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public void saveAll(List<Post> posts) {
        postRepository.saveAll(posts);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(
                new Post(post.getTitle(), post.getUrl())
        );
    }

    @Override
    public void voteNegative(Post post) {
        post.setVoting(post.getVoting() - 1);
        postRepository.save(post);
    }

    @Override
    public void votePositive(Post post) {
        post.setVoting(post.getVoting() + 1); ;
        postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }
}

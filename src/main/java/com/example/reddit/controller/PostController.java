package com.example.reddit.controller;

import com.example.reddit.model.Post;
import com.example.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final int PAGE_SIZE = 10;

    @RequestMapping("/")
    public String indexHandler(
            Model model,
            @RequestParam(
                    value = "pageNumber",
                    required = false,
                    defaultValue = "0")
                    Integer pageNumber
            ) {
        model.addAttribute(
                "posts",
                postService.findAll(
                        PageRequest.of(pageNumber,
                                PAGE_SIZE,
                                Sort.by("voting")
                                        .descending()))
        );
        model.addAttribute("pageNumber", pageNumber);
        return "index";
    }

    @RequestMapping("/vote-negative")
    public String voteNegativeHandler(@RequestParam(value = "id") Long id) {
        postService.voteNegative(postService.findById(id));
        return "redirect:/";
    }

    @RequestMapping("/vote-positive")
    public String votePositiveHandler(@RequestParam(value = "id") Long id) {
        postService.votePositive(postService.findById(id));
        return "redirect:/";
    }

    @GetMapping("/add-new-post")
    public String formNewPostHandler(@ModelAttribute Post post) {
        return "add-post";
    }

    @PostMapping("/add-new-post")
    public String addNewPostHandler(Post post) {
        postService.savePost(post);
        return "redirect:/";
    }
}

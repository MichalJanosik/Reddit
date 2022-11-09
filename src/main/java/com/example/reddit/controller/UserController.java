package com.example.reddit.controller;

import com.example.reddit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public String userLoginHandler(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   RedirectAttributes redirectAttributes
    ) {
        if (Objects.isNull(username)
                        || username.isBlank()
                        || Objects.isNull(password)
                        || password.isBlank()
        ) {
            redirectAttributes.addFlashAttribute(
                    "message",
                    "Entered username or password is empty!"
            );
            return "redirect:/";
        }

        return "redirect:/";
    }
}

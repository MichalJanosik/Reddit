package com.example.reddit;

import com.example.reddit.model.Post;
import com.example.reddit.model.Role;
import com.example.reddit.model.User;
import com.example.reddit.repository.RoleRepository;
import com.example.reddit.repository.UserRepository;
import com.example.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class RedditApplication implements CommandLineRunner {

    private final PostService postService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RedditApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        initialsePosts();

//        addUsersAndRoles();
    }

    private void addUsersAndRoles() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String secret = "{bcrypt}" + encoder.encode("password");

        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);
        Role adminRole = new Role("ROLE_ADMIN");
        roleRepository.save(adminRole);

        User user = new com.example.reddit.model.User("user", secret, true);
        user.addRole(userRole);
        userRepository.save(user);

        User admin = new User("admin", secret, true);
        user.addRole(adminRole);
        userRepository.save(admin);

        User master = new User("master", secret, true);
        master.addRoles(new HashSet<>(Arrays.asList(userRole, adminRole)));
        userRepository.save(master);
    }

    private void initialsePosts() {
        List<Post> posts = new ArrayList<>(List.of(
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf"),
                new Post("fasdlkfjlkja asdf sadf sadf")
        ));
        postService.saveAll(posts);
    }
}

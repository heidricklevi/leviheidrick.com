package com.ljheidrick.backend.controller;

import com.ljheidrick.backend.model.User;
import com.ljheidrick.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BackendController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/user/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);

        userRepository.save(newUser);
        return "saved";
    }

    @GetMapping(path = "/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    

}

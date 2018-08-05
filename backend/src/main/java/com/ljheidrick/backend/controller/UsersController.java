package com.ljheidrick.backend.controller;

import com.ljheidrick.backend.exception.ResourceNotFoundException;
import com.ljheidrick.backend.model.User;
import com.ljheidrick.backend.repository.RoleRepository;
import com.ljheidrick.backend.repository.UserRepository;
import com.ljheidrick.backend.security.CurrentUser;
import com.ljheidrick.backend.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProjectsController.class);


    @GetMapping("/users/{username}")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public @ResponseBody User getUserByUsername(@CurrentUser UserPrincipal userPrincipal, @PathVariable(value = "username") String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }

}

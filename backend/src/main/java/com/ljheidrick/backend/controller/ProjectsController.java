package com.ljheidrick.backend.controller;

import com.ljheidrick.backend.exception.ResourceNotFoundException;
import com.ljheidrick.backend.model.Projects;
import com.ljheidrick.backend.model.User;
import com.ljheidrick.backend.payload.ApiResponse;
import com.ljheidrick.backend.payload.ProjectsRequest;
import com.ljheidrick.backend.repository.ProjectsRepository;
import com.ljheidrick.backend.repository.RoleRepository;
import com.ljheidrick.backend.repository.UserRepository;
import com.ljheidrick.backend.security.CurrentUser;
import com.ljheidrick.backend.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ProjectsController {
    @Autowired
    ProjectsRepository projectsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProjectsController.class);


    @PostMapping("/projects/submit")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public ResponseEntity<?> createProject(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody ProjectsRequest project) {
        Date date = new Date();
        String username = userPrincipal.getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Projects projects = new Projects(project.getTitle(), project.getUrl(), project.getContent());
        projects.setUser(user);
        projects.setFinish(date);
        projects.setStarted(date);

        projectsRepository.save(projects);

        return ResponseEntity.ok().body(new ApiResponse(true, "Created Project"));

    }

    @GetMapping("/projects")
    public @ResponseBody Iterable<Projects> getProjects() {
        return projectsRepository.findAll();
    }



}

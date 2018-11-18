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
import com.ljheidrick.backend.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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

    @Autowired
    FileStorageService service;

    private static final Logger logger = LoggerFactory.getLogger(ProjectsController.class);


    @PostMapping("/projects/submit")
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

    @GetMapping("/projects/{title}")
    public @ResponseBody Projects getProjectById(@Valid @PathVariable String title) {
       return projectsRepository.findByTitle(title);
    }

    @GetMapping("/projects")
    public @ResponseBody Iterable<Projects> getProjects() {
        return projectsRepository.findAll();
    }

    @DeleteMapping("/projects/{id}")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public @ResponseBody Iterable<Projects> deleteProjectById(@PathVariable Long id) {
        projectsRepository.deleteById(id);
        return projectsRepository.findAll();
    }

    @PutMapping("/projects/edit/{id}")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public @ResponseBody Iterable<Projects> editProjectById(@Valid @PathVariable Long id, @Valid @RequestBody ProjectsRequest project) {
        Projects projects = projectsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projects", "project", project));

        projects.setTitle(project.getTitle());
        projects.setContent(project.getContent());
        projects.setUrl(project.getUrl());
        projectsRepository.save(projects);
        return projectsRepository.findAll();
    }

    @PostMapping("/projects/upload")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public @ResponseBody Projects saveImagesToProject(@RequestParam(value = "files") MultipartFile[] files,
                                 @RequestParam(value = "folderName") String folderName,
                                 @RequestParam(value = "projectId") Long id) throws IOException {
        Projects projects = projectsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projects", "project", id));
        projects = service.saveFiles(files, folderName, projects);

        projectsRepository.save(projects);
        return projects;
    }
}

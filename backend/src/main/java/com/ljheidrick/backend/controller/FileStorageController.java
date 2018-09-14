package com.ljheidrick.backend.controller;

import com.ljheidrick.backend.exception.ResourceNotFoundException;
import com.ljheidrick.backend.model.Resume;
import com.ljheidrick.backend.model.User;
import com.ljheidrick.backend.repository.ResumeRepository;
import com.ljheidrick.backend.repository.UserRepository;
import com.ljheidrick.backend.security.CurrentUser;
import com.ljheidrick.backend.security.UserPrincipal;
import com.ljheidrick.backend.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FileStorageController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    FileStorageService service;

    @GetMapping("/resume")
    public List<Resume> getResumeLatest() throws Exception {

        return resumeRepository.findAll();
    }

    @PutMapping("/resume/edit/{fileName}/{id}")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public Resume editResume(@CurrentUser UserPrincipal userPrincipal, @RequestParam(value = "file") MultipartFile image,
                             @PathVariable("fileName") String imgName, @PathVariable("id") Long id, @RequestParam(value = "folderName") String folderName) throws Exception {
        Resume resume = resumeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resume", "resume", id));

        String url = service.saveFile(image, imgName, folderName);
        resume.setUrl(url);

        return resumeRepository.save(resume);
    }

    @PostMapping("/upload/{fileName}")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public Resume saveImage(@CurrentUser UserPrincipal currentUser, @RequestParam(value = "file") MultipartFile image,
                            @PathVariable("fileName") String imgName, @RequestParam(value = "folderName") String folderName) throws IOException {
        String url = service.saveFile(image, imgName, folderName);
        String username = currentUser.getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Resume resume = new Resume(url, user);
        return resumeRepository.save(resume);
    }

    @DeleteMapping("/{name}")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public void deleteById(@PathVariable("fileName") String fileName) throws Exception {
        service.deleteFile(fileName);
    }

}
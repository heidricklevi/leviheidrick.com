package com.ljheidrick.backend.controller;

import com.amazonaws.services.eks.model.ResourceNotFoundException;
import com.ljheidrick.backend.model.About;
import com.ljheidrick.backend.model.Contact;
import com.ljheidrick.backend.model.User;
import com.ljheidrick.backend.payload.AboutRequest;
import com.ljheidrick.backend.payload.ApiResponse;
import com.ljheidrick.backend.payload.ContactRequest;
import com.ljheidrick.backend.repository.AboutRepository;
import com.ljheidrick.backend.repository.ContactRepository;
import com.ljheidrick.backend.repository.UserRepository;
import com.ljheidrick.backend.security.CurrentUser;
import com.ljheidrick.backend.security.UserPrincipal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AboutController {

    @Autowired
    private AboutRepository aboutRepository;

    @Autowired
    private UserRepository userRepository;


    private static final Logger logger = LoggerFactory.getLogger(AboutController.class);


    @PostMapping(value = "/about")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @ResponseBody
    ResponseEntity<?> createAbout(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody AboutRequest aboutRequest) {
      String username = userPrincipal.getUsername();
      User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User"));
      About about = new About (aboutRequest.getPositionTitle(), aboutRequest.getImageUrl(), aboutRequest.getContent(), aboutRequest.getMainTitle());
      about.setUser(user);
      aboutRepository.save(about);
      return ResponseEntity.ok().body(new ApiResponse(true, "Created Project"));
    }

    @PutMapping(value = "/about/{id}")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @ResponseBody
    ResponseEntity<?> updateAbout(@PathVariable Long id, @Valid @RequestBody AboutRequest aboutRequest) {

      About about = aboutRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("About"));
      about.setContent(aboutRequest.getContent());
      about.setImageUrl(aboutRequest.getImageUrl());
      about.setMainTitle(aboutRequest.getMainTitle());
      about.setPositionTitle(aboutRequest.getPositionTitle());
      aboutRepository.save(about);

      return ResponseEntity.ok().body(new ApiResponse(true, "Updated Project"));
    }

    @GetMapping("/about")
    public @ResponseBody Iterable<About> getAbout() {
        return aboutRepository.findAll();
    }
}

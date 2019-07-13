package com.ljheidrick.backend.controller;

import javax.validation.Valid;

import com.ljheidrick.backend.exception.ResourceNotFoundException;
import com.ljheidrick.backend.model.TechSkills;
import com.ljheidrick.backend.model.User;
import com.ljheidrick.backend.payload.ApiResponse;
import com.ljheidrick.backend.payload.TechSkillsRequest;
import com.ljheidrick.backend.repository.RoleRepository;
import com.ljheidrick.backend.repository.TechSkillsRepository;
import com.ljheidrick.backend.repository.UserRepository;
import com.ljheidrick.backend.security.CurrentUser;
import com.ljheidrick.backend.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TechSkillsController {
  @Autowired
  UserRepository userRepository;

  @Autowired
  TechSkillsRepository techSkillsRepository;

  @Autowired
  RoleRepository roleRepository;

  @GetMapping("/techSkills")
  public @ResponseBody Iterable<TechSkills> getTechSkills() {
      return techSkillsRepository.findAll();
  }

  @PostMapping("/techSkills/create")
  @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
  public ResponseEntity<?> createTechSkill(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody TechSkillsRequest techSkillsRequest) {
      String username = userPrincipal.getUsername();
      User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
      TechSkills techSkills = new TechSkills(techSkillsRequest.getName(), techSkillsRequest.getImageUrl(), techSkillsRequest.getUrl());
      techSkills.setUser(user);

      techSkillsRepository.save(techSkills);

      return ResponseEntity.ok().body(new ApiResponse(true, "Added Skill"));
  }

}
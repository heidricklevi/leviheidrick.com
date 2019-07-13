package com.ljheidrick.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "techSkills")
public class TechSkills {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String imageUrl;

  @Nullable
  private String url; 

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public TechSkills(@NotBlank String name, @NotBlank String imageUrl, String url) {
    this.name = name;
    this.imageUrl = imageUrl;
    this.url = url;
  }

  public TechSkills() {
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
package com.ljheidrick.backend.payload;

import javax.validation.constraints.NotBlank;

public class TechSkillsRequest {
  @NotBlank
  private String name;

  private String url;
  
  @NotBlank
  private String imageUrl;

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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
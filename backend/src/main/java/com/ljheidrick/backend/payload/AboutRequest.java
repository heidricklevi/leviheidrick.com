package com.ljheidrick.backend.payload;

import javax.validation.constraints.NotBlank;

public class AboutRequest {
  @NotBlank
  private String imageUrl;
  @NotBlank
  private String positionTitle;
  @NotBlank
  private String content;
  @NotBlank
  private String mainTitle;
  private Boolean isActive = false;

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getPositionTitle() {
    return positionTitle;
  }

  public void setPositionTitle(String positionTitle) {
    this.positionTitle = positionTitle;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getMainTitle() {
    return mainTitle;
  }

  public void setMainTitle(String mainTitle) {
    this.mainTitle = mainTitle;
  }

  public AboutRequest(@NotBlank String imageUrl, @NotBlank String positionTitle, @NotBlank String content,
      @NotBlank String mainTitle, Boolean isActive) {
    this.imageUrl = imageUrl;
    this.positionTitle = positionTitle;
    this.content = content;
    this.mainTitle = mainTitle;
    this.isActive = isActive;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }
}
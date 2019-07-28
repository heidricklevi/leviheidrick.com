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
      @NotBlank String mainTitle) {
    this.imageUrl = imageUrl;
    this.positionTitle = positionTitle;
    this.content = content;
    this.mainTitle = mainTitle;
  }
}
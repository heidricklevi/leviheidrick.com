package com.ljheidrick.backend.payload;

import com.ljheidrick.backend.model.Files;

import java.util.List;

public class ProjectsRequest {
    private String url;
    private String title;
    private String content;
    private List<Files> files;

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }
}

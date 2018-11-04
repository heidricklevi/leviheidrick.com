package com.ljheidrick.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class Files  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileUrl;

    public Files () {

    }

    public Files (String url) {
        this.fileUrl = url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

}

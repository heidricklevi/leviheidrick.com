package com.ljheidrick.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class Files  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "tinyint(0) default 0")
    private Boolean isBacksplash;

    private String fileUrl;

    public Files () {

    }

    public Files (String url, Boolean isBacksplash) {
        this.fileUrl = url;
        this.isBacksplash = isBacksplash;
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

    public Boolean getIsBacksplash() {
        return isBacksplash;
    }

    public void setBacksplash(Boolean isBacksplash) {
        this.isBacksplash = isBacksplash;
    }
}

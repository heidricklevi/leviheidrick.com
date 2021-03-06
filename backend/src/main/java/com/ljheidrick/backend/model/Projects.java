package com.ljheidrick.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String title;

    @NotNull
    private String url;

    private Date started;
    private Date finish;

    @NotNull
    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @OneToMany
    @JoinColumn(name = "files_id")
    private List<Files> files;

    @Nullable
    @ElementCollection
    private List<String> techStack = new ArrayList<String>();

    @Nullable
    private String githubLink;

    public Projects() {

    }

    public Projects(String title, String url, String content) {
        this.content = content;
        this.url = url;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getFinish() {
        return finish;
    }

    public Date getStarted() {
        return started;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public User getUser() {
        return user;
    }

    public Optional<List<Files>> getFiles() {
        return Optional.ofNullable(files);
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public void setContent(String content) {
            this.content = content;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Optional<List<String>> getTechStack () {
        return Optional.ofNullable(techStack);
    }

    public void setTechStatck (List<String> techStack) {
        this.techStack = techStack;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }
}

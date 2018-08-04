package com.ljheidrick.backend.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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


        public Projects(String title, String url, String content) {
            this.content = content;
            this.finish = finish;
            this.started = started;
            this.url = url;
            this.title = title;
            this.user = user;
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
}

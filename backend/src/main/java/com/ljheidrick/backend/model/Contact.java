package com.ljheidrick.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table
@Entity(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String fromEmail;

    @NotBlank
    private String senderName;

    @NotBlank
    @Size(max = 10000)
    @Lob
    private String message;

    public Contact () {

    }

    public Contact (String fromEmail, String senderName, String message) {
        this.fromEmail = fromEmail;
        this.senderName = senderName;
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getMessage() {
        return message;
    }

    public Long getId() {
        return id;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

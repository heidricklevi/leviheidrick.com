package com.ljheidrick.backend.payload;

import javax.validation.constraints.NotBlank;

public class ContactRequest {

    @NotBlank
    private String senderName;

    @NotBlank
    private String fromEmail;

    @NotBlank
    private String message;


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}

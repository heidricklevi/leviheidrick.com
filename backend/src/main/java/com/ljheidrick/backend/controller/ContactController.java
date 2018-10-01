package com.ljheidrick.backend.controller;

import com.ljheidrick.backend.model.Contact;
import com.ljheidrick.backend.payload.ContactRequest;
import com.ljheidrick.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private ContactRepository contactRepository;

    @Value("${contact.toEmail}")
    private String toEmail;

    @Value("${contact.fromEmail}")
    private String fromEmail;


    @PostMapping(value = "/contact/send")
    @ResponseBody
    ResponseEntity<?> submitContact(@Valid @RequestBody ContactRequest contactRequest) {
        try {
            Contact contact = new Contact(contactRequest.getFromEmail(), contactRequest.getSenderName(), contactRequest.getMessage());

            contactRepository.save(contact);
            sendEmail(contactRequest);
            return ResponseEntity.ok("Successfully sent email");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error " + e);
        }
    }

    private void sendEmail(ContactRequest contactRequest) throws MessagingException {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);

        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(formatEmailContent(contactRequest), true);
        mimeMessageHelper.setSubject("A message from"+contactRequest.getSenderName());

        sender.send(message);
    }

    private String formatEmailContent(ContactRequest contactRequest) {
        return String.format("<div><h4>Details</h4><ul><li>From: %s</li></ul></ br><h4>Content</h4>%s</div>", contactRequest.getFromEmail(), contactRequest.getMessage());
    }

}

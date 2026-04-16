package com.example.resourceapp.model;
import jakarta.persistence.*;
@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String link;
    private String subject;
    // Constructors
    public Resource() {}
    public Resource(String title, String description, String link, String subject) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.subject = subject;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}




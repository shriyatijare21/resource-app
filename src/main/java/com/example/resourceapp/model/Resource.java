package com.example.resourceapp.model;

// JPA annotations (used to map class → database table)
import jakarta.persistence.*;

// Validation annotations (to check user input)
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// Marks this class as a database table
@Entity
public class Resource {

    // Primary key (unique ID for each record)
    @Id

    // Auto-generates ID (1, 2, 3, ...)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Title should not be empty
    @NotBlank(message = "Title is required")
    private String title;

    // Description should not be empty
    @NotBlank(message = "Description is required")
    private String description;

    // Link should not be empty
    @NotBlank(message = "Link is required")

    // Link must start with http or https
    @Pattern(regexp = "^(http|https)://.*$", 
             message = "Link must be valid (http/https)")
    private String link;

    // Subject should not be empty
    @NotBlank(message = "Subject is required")
    private String subject;

    // Default constructor (required by JPA)
    public Resource() {}

    // Parameterized constructor (used to create object with values)
    public Resource(String title, String description, String link, String subject) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.subject = subject;
    }

    // Getters and Setters → used to access and modify data

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
package com.example.resourceapp;

// Used to start the Spring Boot app
import org.springframework.boot.SpringApplication;

// Main annotation that sets up Spring Boot automatically
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This is the main class (starting point of the project)
@SpringBootApplication
public class ResourceAppApplication {

    // Main method → program starts from here
    public static void main(String[] args) {

        // Runs the Spring Boot application
        // Starts server (Tomcat) and loads all components
        SpringApplication.run(ResourceAppApplication.class, args);
    }
}

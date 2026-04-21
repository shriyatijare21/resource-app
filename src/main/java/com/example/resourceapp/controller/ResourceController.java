package com.example.resourceapp.controller;

// Used for validation (checks fields like empty, invalid link, etc.)
import jakarta.validation.Valid;

import com.example.resourceapp.model.Resource;
import com.example.resourceapp.service.ResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

// Marks this class as REST API controller (returns JSON data)
@RestController

// Base URL → all APIs will start with /resources
@RequestMapping("/resources")

// Allows frontend (HTML/JS) to call backend (important for browser)
@CrossOrigin(origins = "*")
public class ResourceController {

    // Connects Service layer (business logic)
    @Autowired
    private ResourceService service;

    //  ADD RESOURCE (POST request)
    @PostMapping
    public ResponseEntity<?> addResource(
            @Valid @RequestBody Resource resource // takes JSON input + validates it
    ) {
        // Calls service to save data and returns response
        return ResponseEntity.ok(service.addResource(resource));
    }

    //  GET ALL RESOURCES (GET request)
    @GetMapping
    public List<Resource> getAllResources() {
        // Fetches all resources from service
        return service.getAllResources();
    }

    // ❌ DELETE RESOURCE (DELETE request)
    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        // Deletes resource using ID
        service.deleteResource(id);
    }
}
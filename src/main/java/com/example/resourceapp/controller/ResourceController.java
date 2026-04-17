package com.example.resourceapp.controller;

import jakarta.validation.Valid;
import com.example.resourceapp.model.Resource;
import com.example.resourceapp.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "*")  // allow frontend calls
public class ResourceController {

    @Autowired
    private ResourceService service;

    // ✅ Add resource with validation
    @PostMapping
    public ResponseEntity<?> addResource(@Valid @RequestBody Resource resource) {
        return ResponseEntity.ok(service.addResource(resource));
    }

    // Get all resources
    @GetMapping
    public List<Resource> getAllResources() {
        return service.getAllResources();
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        service.deleteResource(id);
    }
}
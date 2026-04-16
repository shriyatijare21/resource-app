package com.example.resourceapp.controller;

import com.example.resourceapp.model.Resource;
import com.example.resourceapp.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService service;

    // Add resource
    @PostMapping
    public Resource addResource(@RequestBody Resource resource) {
        return service.addResource(resource);
    }

    // Get all resources
    @GetMapping
    public List<Resource> getAllResources() {
        return service.getAllResources();
    }

    // Delete resource
    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        service.deleteResource(id);
    }
}
package com.example.resourceapp.service;

import com.example.resourceapp.model.Resource;
import com.example.resourceapp.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repository;

    // Add resource
    public Resource addResource(Resource resource) {
        return repository.save(resource);
    }

    // Get all resources
    public List<Resource> getAllResources() {
        return repository.findAll();
    }

    // Delete resource
    public void deleteResource(Long id) {
        repository.deleteById(id);
    }
}
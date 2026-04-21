package com.example.resourceapp;

import com.example.resourceapp.model.Resource;
import com.example.resourceapp.service.ResourceService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

// Enables full Spring Boot test
import org.springframework.boot.test.context.SpringBootTest;

// Allows testing controller without starting real server
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

// Used to mock (fake) service layer
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

// Mockito + MockMvc helpers
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Load full application context
@SpringBootTest

// Enables MockMvc for testing APIs
@AutoConfigureMockMvc
public class ResourceControllerTest {

    // Used to simulate HTTP requests (GET, POST, etc.)
    @Autowired
    private MockMvc mockMvc;

    // Converts Java object → JSON
    @Autowired
    private ObjectMapper objectMapper;

    // Creates fake version of service (so DB is not used)
    @MockBean
    private ResourceService service;


    //  Test 1: Valid input (should PASS)
    @Test
    void testAddResource_Valid() throws Exception {

        // Create test object
        Resource resource = new Resource();
        resource.setTitle("Java Notes");
        resource.setDescription("DSA basics");
        resource.setLink("https://google.com");
        resource.setSubject("DSA");

        // Mock service response
        when(service.addResource(any(Resource.class))).thenReturn(resource);

        // Perform POST request
        mockMvc.perform(post("/resources")
                .contentType(MediaType.APPLICATION_JSON)

                // Convert object → JSON
                .content(objectMapper.writeValueAsString(resource)))

                // Expect HTTP 200 OK
                .andExpect(status().isOk())

                // Check response contains correct title
                .andExpect(jsonPath("$.title").value("Java Notes"));
    }


    // Test 2: Invalid input (should FAIL)
    @Test
    void testAddResource_Invalid() throws Exception {

        // Send empty JSON → validation should fail
        mockMvc.perform(post("/resources")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))

                // Expect HTTP 400 Bad Request
                .andExpect(status().isBadRequest());
    }


    //  Test 3: Get all resources
    @Test
    void testGetAllResources() throws Exception {

        // Create sample data
        Resource r1 = new Resource();
        r1.setTitle("Java");

        // Mock service response
        when(service.getAllResources()).thenReturn(List.of(r1));

        // Perform GET request
        mockMvc.perform(get("/resources"))

                // Expect HTTP 200 OK
                .andExpect(status().isOk())

                // Check first item title
                .andExpect(jsonPath("$[0].title").value("Java"));
    }
}
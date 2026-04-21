package com.example.resourceapp;
import com.example.resourceapp.model.Resource;
import com.example.resourceapp.service.ResourceService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ResourceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ResourceService service;
    // Test: Valid input (should PASS)
    @Test
    void testAddResource_Valid() throws Exception {
        Resource resource = new Resource();
        resource.setTitle("Java Notes");
        resource.setDescription("DSA basics");
        resource.setLink("https://google.com");
        resource.setSubject("DSA");
        when(service.addResource(any(Resource.class))).thenReturn(resource);
        mockMvc.perform(post("/resources")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(resource)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Java Notes"));
    }
    //  Test: Invalid input (empty fields → should FAIL)
    @Test
    void testAddResource_Invalid() throws Exception {
        mockMvc.perform(post("/resources")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());
    }
    //  Test: Get all resources
    @Test
    void testGetAllResources() throws Exception {
        Resource r1 = new Resource();
        r1.setTitle("Java");
        when(service.getAllResources()).thenReturn(List.of(r1));
        mockMvc.perform(get("/resources"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Java"));
    }
}
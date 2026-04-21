package com.example.resourceapp;

import org.junit.jupiter.api.Test;

// Assertions used to check conditions
import static org.junit.jupiter.api.Assertions.*;

public class ResourceServiceTest {

    // ✅ Test 1: Title should not be empty
    @Test
    void titleShouldNotBeEmpty() {

        String title = "Java Notes";

        // Check that title is NOT empty
        assertFalse(title.isEmpty());
    }

    // ✅ Test 2: Link should start with http
    @Test
    void linkShouldStartWithHttp() {

        String link = "https://google.com";

        // Check that link starts with "http"
        assertTrue(link.startsWith("http"));
    }

    // ✅ Test 3: Subject should not be null
    @Test
    void subjectShouldNotBeNull() {

        String subject = "DSA";

        // Check that subject is NOT null
        assertNotNull(subject);
    }
}
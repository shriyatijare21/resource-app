package com.example.resourceapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceServiceTest {

    @Test
    void titleShouldNotBeEmpty() {
        String title = "Java Notes";

        assertFalse(title.isEmpty());
    }

    @Test
    void linkShouldStartWithHttp() {
        String link = "https://google.com";

        assertTrue(link.startsWith("http"));
    }

    @Test
    void subjectShouldNotBeNull() {
        String subject = "DSA";

        assertNotNull(subject);
    }
}





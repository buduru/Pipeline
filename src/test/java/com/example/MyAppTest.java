package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyAppTest {
    @Test
    public void testApp() {
        String message = "Hello, CI/CD from Jenkins on AWS!";
        assertEquals("Hello, CI/CD from Jenkins on AWS!", message);
    }
}

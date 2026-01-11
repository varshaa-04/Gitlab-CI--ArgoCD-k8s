package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloAppTest {

    @Test
    void testGreet() {
        assertEquals("Hello from Java CI Pipeline!", HelloApp.greet());
    }
}

package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class MessageGenerationServiceTest {

    private GreetingGenerationService service = new GreetingGenerationService();

    @Test
    void createMessage() {
        var input = "Mike";
        assertEquals(service.createMessage(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))), "Hello, Mike");
    }
}
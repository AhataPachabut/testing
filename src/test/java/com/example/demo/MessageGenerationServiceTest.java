package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MessageGenerationServiceTest {

    private MessageGenerationService service = new MessageGenerationService();

    @Test
    void createMessageWithParamsFromConsole() {
        //mock input from console
        assertEquals(service.createMessageWithParamsFromConsole(), "Hello, Mike");
    }

    @Test
    void createMessageWithParamsFromFile() {
        //mock read from file
        assertEquals(service.createMessageWithParamsFromFile("input.txt"), "Hello, Mike");
    }
}
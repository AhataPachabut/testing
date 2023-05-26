package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MessageGenerationService {

    private static String template = "Hello #{name}";

    public String createMessageWithParamsFromConsole() {
        return null;
    }

    public String createMessageWithParamsFromFile(String inputFileName) {
        return null;
    }
}

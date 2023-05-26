package com.example.demo;

import java.io.InputStream;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class GreetingGenerationService implements MessageGenerator {

    private static String template = "Hello, #{name} and #{name1}";

    @Override
    public String createMessage(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        String params = scanner.nextLine();
        scanner.close();

        String result = template;
        for (var s : params.split(",")) {
            var index = s.indexOf("=");
            result = result.replace("#{" + s.substring(0, index).trim() + "}", s.substring(index + 1).trim());
        }

        if (result.matches("\\#\\{\\\\w\\+\\}")) {
            throw new RuntimeException("Not enough params");
        }

        return result;
    }
}

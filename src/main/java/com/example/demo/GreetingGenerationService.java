package com.example.demo;

import java.io.InputStream;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class GreetingGenerationService implements MessageGenerator {

    private static String template = "Hello, #{name}";
    private static String[] params = {"name"};

    @Override
    public String createMessage(InputStream inputStream) {
        String result = template;
        Scanner scanner = new Scanner(inputStream);
        for (var param : params) {
            System.out.printf("%s=", param);
            var value = scanner.nextLine();
            result = result.replace("#{" + param + "}", value);
        }
        scanner.close();
        System.out.println(result);
        return result;
    }
}

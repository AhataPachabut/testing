package com.example.demo;

import java.io.FileInputStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(GreetingGenerationService service) {
        return args -> {
            if (args.length > 0) {
                service.createMessage(new FileInputStream(args[0]));
            } else {
                service.createMessage(System.in);
            }
        };
    }
}

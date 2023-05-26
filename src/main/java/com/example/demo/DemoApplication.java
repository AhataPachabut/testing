package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
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
                System.out.println("Read params from file");
                var result = service.createMessage(new FileInputStream(args[0]));
                System.out.println("Write params to file");
                var output = new FileOutputStream(args[1]);
                output.write(result.getBytes(StandardCharsets.UTF_8));
                output.close();
            } else {
                System.out.println("Insert params");
                var result = service.createMessage(System.in);
                System.out.println(result);
            }
        };
    }
}

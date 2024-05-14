package com.clipit.clipitback;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ClipitBackApplication {
    @Value("${secret-key}")
    static private String secretKey;

    public static void main(String[] args) {
        System.out.println(secretKey);
        SpringApplication.run(ClipitBackApplication.class, args);
    }

}

package com.example.kazezahmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KazezAhmedApplication {

    public static void main(String[] args) {
        SpringApplication.run(KazezAhmedApplication.class, args);
    }

}

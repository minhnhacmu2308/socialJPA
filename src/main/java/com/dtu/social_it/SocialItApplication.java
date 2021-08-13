package com.dtu.social_it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.dtu.social_it.*")
@SpringBootApplication
public class SocialItApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialItApplication.class, args);
    }

}

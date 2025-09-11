package com.jonatas.desafiocep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioCepApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioCepApplication.class, args);
    }
}

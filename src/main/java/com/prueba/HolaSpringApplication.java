package com.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.prueba.dao")
@EntityScan(basePackages = "com.prueba.domain")
public class HolaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(HolaSpringApplication.class, args);
    }
}



package com.sid.gl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.sid.gl")
@EnableJpaRepositories(basePackages = {"com.sid.gl.adapter.repository.business"})
@EntityScan(basePackages = "com.sid.gl.adapter.repository.business.entities")
public class HexagonalBisApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(HexagonalBisApplication.class, args);
    }
}
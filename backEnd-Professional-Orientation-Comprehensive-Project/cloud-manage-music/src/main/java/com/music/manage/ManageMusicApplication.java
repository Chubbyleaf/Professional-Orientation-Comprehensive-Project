package com.music.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableWebMvc
public class ManageMusicApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageMusicApplication.class, args);
    }
}

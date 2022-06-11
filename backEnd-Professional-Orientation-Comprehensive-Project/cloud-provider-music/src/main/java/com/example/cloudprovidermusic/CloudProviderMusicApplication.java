package com.example.cloudprovidermusic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.example.cloudprovidermusic.dao")
@SpringBootApplication
public class CloudProviderMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderMusicApplication.class, args);
    }

}

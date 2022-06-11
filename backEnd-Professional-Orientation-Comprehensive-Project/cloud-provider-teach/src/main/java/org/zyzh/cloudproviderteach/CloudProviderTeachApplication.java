package org.zyzh.cloudproviderteach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudProviderTeachApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderTeachApplication.class, args);
    }

}

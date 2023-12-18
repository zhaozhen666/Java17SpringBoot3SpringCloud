package com.zhao.sbsc17;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
@MapperScan("com.zhao.sbsc17")
public class Sbsc17Application {

    public static void main(String[] args) {
        SpringApplication.run(Sbsc17Application.class, args);
    }

}

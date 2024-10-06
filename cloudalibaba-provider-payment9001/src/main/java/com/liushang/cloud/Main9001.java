package com.liushang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liushang
 * @date 2024-10-06 20:05:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main9001 {

    public static void main(String[] args) {
        SpringApplication.run(Main9001.class,args);
    }
}

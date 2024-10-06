package com.liushang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liushang
 * @date 2024-10-06 21:35:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main83 {

    public static void main(String[] args)
    {
        SpringApplication.run(Main83.class,args);
    }
}

package com.liushang.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liushang
 * @date 2024-10-06 22:01:53
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate()
    {
        //测试nacos作为注册中心时客户端的负载均衡功能
        return new RestTemplate();
    }
}

package com.liushang.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liushang
 * @date 2024-09-24 23:27:54
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetryer()
    {
//        return Retryer.NEVER_RETRY; //Feign默认配置是不走重试策略的

        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
//        Retryer.Default 方法接受三个参数，分别用于配置重试策略的相关参数：
//
//        Per-Retry Interval (重试间隔时间): 第一个参数表示初始的重试间隔时间，即在第一次请求失败后，等待多久进行第一次重试。单位为毫秒。
//
//        Max Interval (最大重试间隔时间): 第二个参数表示重试间的最大间隔时间，即每次重试的间隔时间会逐渐增加，但不会超过这个最大间隔时间。单位为毫秒。
//
//        Max Attempts (最大请求次数): 第三个参数表示最大的请求重试次数，包括初始请求和重试次数。例如，如果设置为3，则表示最多进行2次重试（总共3次请求，包括初始请求）。
        return new Retryer.Default(100,1000,3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}

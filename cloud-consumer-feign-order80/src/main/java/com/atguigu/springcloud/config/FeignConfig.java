package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 日志打印
 * @Author xwz
 * @Date 2020/5/28 14:22
 * @Version 1.0
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        //打印详细日志
        return Logger.Level.FULL;
    }
}

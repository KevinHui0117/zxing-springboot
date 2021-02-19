package com.zgh.xxg.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: huik
 * @create: 2021-01-28
 **/
@Configuration
public class DateSourseConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource getDruid(){
        return new DruidDataSource();
    }
}

    
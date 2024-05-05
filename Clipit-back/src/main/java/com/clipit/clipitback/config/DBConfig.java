package com.clipit.clipitback.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.clipit.clipitback.model.dao")
public class DBConfig {

}

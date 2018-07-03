package com.zhumeng.uimei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //排除DataSourceConfiguratrion
@PropertySource({"classpath:config.properties"})
@EnableTransactionManagement(proxyTargetClass = true)   //开启事物管理功能
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


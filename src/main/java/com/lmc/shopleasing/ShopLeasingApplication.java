package com.lmc.shopleasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@ComponentScan(basePackages = "com.lmc.shopleasing",
        excludeFilters =  {@ComponentScan.Filter(classes = {Controller.class, ControllerAdvice.class})})
@MapperScan("com.lmc.shopleasing.dao")
@EnableCaching
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ShopLeasingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopLeasingApplication.class, args);
    }

}

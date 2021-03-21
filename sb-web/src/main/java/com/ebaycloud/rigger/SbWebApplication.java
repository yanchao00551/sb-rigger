package com.ebaycloud.rigger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ebaycloud.rigger.persistence.mapper")
@SpringBootApplication
public class SbWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbWebApplication.class, args);
    }

}

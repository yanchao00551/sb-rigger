package com.ebaycloud.rigger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 *
 * @author 悟空
 * @description //TODO 
 * @date 23:19 2021/4/2
 * @param null
 * @return null
 */
@MapperScan("com.ebaycloud.rigger.persistence.mapper")
@SpringBootApplication
public class SbWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbWebApplication.class, args);
    }

}

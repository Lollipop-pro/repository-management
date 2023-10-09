package com.cooper.factorymanager.Generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.cooper.factorymanager.Generator.*.mapper")
public class FactoryManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryManagerApplication.class, args);
    }

}

package com.luru.luru;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luru.luru.mapper")
public class LuruApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuruApplication.class, args);
    }

}

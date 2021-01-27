package com.example.chipimp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.chipimp.dao")
public class ChipimpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChipimpApplication.class, args);
    }

}

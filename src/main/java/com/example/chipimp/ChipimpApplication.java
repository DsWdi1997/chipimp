package com.example.chipimp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.example.chipimp.dao")
@ImportResource(locations={"classpath:kaptchaConfig.xml"})
public class ChipimpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChipimpApplication.class, args);
    }

}

package com.k.kaicodefather;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.k.kaicodefather.mapper")
public class KAiCodeFatherApplication {
    public static void main(String[] args) {
        SpringApplication.run(KAiCodeFatherApplication.class, args);
    }

}

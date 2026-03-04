package com.k.kaicodefather;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author KuangZixian
 */
@SpringBootApplication(exclude = RedisEmbeddingStoreAutoConfiguration.class)
@MapperScan("com.k.kaicodefather.mapper")
public class KAiCodeFatherApplication {
    public static void main(String[] args) {
        SpringApplication.run(KAiCodeFatherApplication.class, args);
    }

}

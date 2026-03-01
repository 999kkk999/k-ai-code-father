package com.k.kaicodefather.ai;

import com.k.kaicodefather.ai.model.HtmlCodeResult;
import com.k.kaicodefather.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: AiCodeGeneratorServiceTest
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/3/1 16:11
 * @Version 1.0
 */
@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode("做一个程序员江桥的博客，不超过 20 行");
        Assertions.assertNotNull(result);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult result = aiCodeGeneratorService.generateMultiFileCode("做一个程序员江桥的留言板，不超过 20 行");
        Assertions.assertNotNull( result);
    }
}
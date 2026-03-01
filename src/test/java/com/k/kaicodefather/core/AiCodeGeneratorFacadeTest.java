package com.k.kaicodefather.core;

import com.k.kaicodefather.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;


/**
 * ClassName: AiCodeGeneratorFacadeTest
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/3/1 19:10
 * @Version 1.0
 */
@SpringBootTest
class AiCodeGeneratorFacadeTest {

    @Resource
    private AiCodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateAndSaveCode() {
        File file = aiCodeGeneratorFacade.generateAndSaveCode("做一个登录页面，总共不超过 20 行", CodeGenTypeEnum.MULTI_FILE);
        Assertions.assertNotNull(file);
    }
}
package com.k.kaicodefather.core;

import com.k.kaicodefather.ai.AiCodeGeneratorService;
import com.k.kaicodefather.ai.model.HtmlCodeResult;
import com.k.kaicodefather.ai.model.MultiFileCodeResult;
import com.k.kaicodefather.exception.BusinessException;
import com.k.kaicodefather.exception.ErrorCode;
import com.k.kaicodefather.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * ClassName: AiCodeGeneratorFacade
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/3/1 19:01
 * @Version 1.0
 */

/**
 * AI 代码生成门面类,组合代码生成和保存功能
 * @author KuangZixian
 */
@Service
public class AiCodeGeneratorFacade {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    /**
     * 统一入口： 生成代码并保存
     *
     * @param userMessage     用户消息
     * @param codeGenTypeEnum 代码生成类型
     * @return 生成的代码文件
     */
    public File generateAndSaveCode(String userMessage, CodeGenTypeEnum codeGenTypeEnum) {
        if (codeGenTypeEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }

        return switch (codeGenTypeEnum) {
            case HTML -> generateAndSaveHtmlCode(userMessage);
            case MULTI_FILE -> generateAndSaveMultiFileCode(userMessage);
            default -> {
                String errorMessage = "不支持的代码生成类型" + codeGenTypeEnum.getValue();
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
            }
        };
    }

    /**
     *
     * 生成HTML模式的代码并保存
     *
     * @param userMessage 用户消息
     * @return 生成的代码文件
     */
    private File generateAndSaveHtmlCode(String userMessage) {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode(userMessage);
        return CodeFileSaver.saveHtmlCodeResult(result);
    }

    /**
     *
     * 生成多文件模式的代码并保存
     *
     * @param userMessage 用户消息
     * @return 生成的代码文件
     */
    private File generateAndSaveMultiFileCode(String userMessage) {
        MultiFileCodeResult result = aiCodeGeneratorService.generateMultiFileCode(userMessage);
        return CodeFileSaver.saveMultiFileCodeResult(result);
    }
}

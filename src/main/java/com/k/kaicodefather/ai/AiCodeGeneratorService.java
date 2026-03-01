package com.k.kaicodefather.ai;

import com.k.kaicodefather.ai.model.HtmlCodeResult;
import com.k.kaicodefather.ai.model.MultiFileCodeResult;
import dev.langchain4j.service.SystemMessage;

/**
 * ClassName: AiCodeGeneratorService
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/3/1 16:04
 * @Version 1.0
 */
public interface AiCodeGeneratorService {

    /**
     * 生成 HTML 代码
     *
     * @param userMessage 用户消息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    HtmlCodeResult generateHtmlCode(String userMessage);

    /**
     * 生成多文件代码
     *
     * @param userMessage 用户消息
     * @return 生成的代码结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    MultiFileCodeResult generateMultiFileCode(String userMessage);
}


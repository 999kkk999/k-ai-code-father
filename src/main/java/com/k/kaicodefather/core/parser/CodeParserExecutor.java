package com.k.kaicodefather.core.parser;

import com.k.kaicodefather.exception.BusinessException;
import com.k.kaicodefather.exception.ErrorCode;
import com.k.kaicodefather.model.enums.CodeGenTypeEnum;

/**
 * 代码解析执行器
 * 根据代码生成类型执行相应的解析逻辑
 *
 *
 * @author KuangZixian
 */
public class CodeParserExecutor {

    /**
     * HTML 单文件代码解析器
     */
    private static final HtmlCodeParser HTML_CODE_PARSER = new HtmlCodeParser();

    /**
     * 多文件代码解析器
     */
    private static final MultiFileCodeParser MULTI_FILE_CODE_PARSER = new MultiFileCodeParser();

    /**
     * 执行代码解析
     *
     * @param codeContent 代码内容
     * @param codeGenType 代码生成类型
     * @return 解析结果（HtmlCodeResult 或 MultiFileCodeResult）
     */
    public static Object executeParser(String codeContent, CodeGenTypeEnum codeGenType) {
        return switch (codeGenType) {
            case HTML -> HTML_CODE_PARSER.parseCode(codeContent);
            case MULTI_FILE -> MULTI_FILE_CODE_PARSER.parseCode(codeContent);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型: " + codeGenType);
        };
    }
}

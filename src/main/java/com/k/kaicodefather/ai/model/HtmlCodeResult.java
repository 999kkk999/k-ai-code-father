package com.k.kaicodefather.ai.model;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

/**
 * ClassName: HtmlCodeResult
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/3/1 16:31
 * @Version 1.0
 */

/**
 * HTML 代码结果
 */
@Description("生成 HTML 代码文件的结果")
@Data
public class HtmlCodeResult {

    @Description("HTML代码")
    private String htmlCode;

    @Description("生成代码的描述")
    private String description;
}


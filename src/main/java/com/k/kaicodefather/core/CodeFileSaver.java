package com.k.kaicodefather.core;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.k.kaicodefather.ai.model.HtmlCodeResult;
import com.k.kaicodefather.ai.model.MultiFileCodeResult;
import com.k.kaicodefather.model.enums.CodeGenTypeEnum;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * ClassName: CodeFileSaver
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/3/1 18:27
 * @Version 1.0
 */

/**
 * 文件保存器
 * @author KuangZixian
 */
public class CodeFileSaver {

    /**
     * 保存文件根目录
     */
    private static final String FILE_SAVE_ROOT_DIR =System.getProperty("user.dir")+ "/tmp/code_output/" ;

    /**
     * 保存 Html网页代码
     * @param result
     */
    public static File saveHtmlCodeResult(HtmlCodeResult result) {
        String baseDirPath = buildUniqueDirPath(CodeGenTypeEnum.HTML.getValue());
        writeToFile(baseDirPath,"index.html",result.getHtmlCode());
        return new File(baseDirPath) ;
    }


    /**
     * 保存 多文件网页代码
     * @param result
     * @return
     */
    public static File saveMultiFileCodeResult(MultiFileCodeResult result) {
        String baseDirPath = buildUniqueDirPath(CodeGenTypeEnum.MULTI_FILE.getValue());
        writeToFile(baseDirPath,"index.html",result.getHtmlCode());
        writeToFile(baseDirPath,"style.css",result.getCssCode());
        writeToFile(baseDirPath,"script.js",result.getJsCode());
        return new File(baseDirPath) ;
    }
    /**
     * 构建唯一目录路径：tmp/code_output/bizType_雪花 id
     */
    private static String buildUniqueDirPath(String bizType) {
        String uniqueDirName = StrUtil.format("{}_{}",bizType, IdUtil.getSnowflakeNextIdStr());
        String dirPath = FILE_SAVE_ROOT_DIR+ File.separator+uniqueDirName;
        FileUtil.mkdir(dirPath);
        return  dirPath;
    }

    /**
     * 写入单个文件
     * @param dirPath
     * @param fileName
     * @param content
     */
    private static void writeToFile(String dirPath,String fileName,String content) {
        String filePath= dirPath+File.separator+fileName;
        FileUtil.writeUtf8String(content,filePath);
    }
}

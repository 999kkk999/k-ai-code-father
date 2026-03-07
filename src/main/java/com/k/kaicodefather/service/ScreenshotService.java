package com.k.kaicodefather.service;

/**
 * ClassName: screenshotService
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/3/7 16:05
 * @Version 1.0
 */
public interface ScreenshotService {

    /**
     * 生成网页截图并保存
     *
     * @param url 网页URL
     * @return 截图保存路径，失败返回null
     */
    String generateAndUploadScreenshot(String url);
}

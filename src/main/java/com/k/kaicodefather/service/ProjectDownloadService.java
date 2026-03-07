package com.k.kaicodefather.service;

import jakarta.servlet.http.HttpServletResponse;

/**
 * ClassName: ProjectDownloadService
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/3/7 20:16
 * @Version 1.0
 */
public interface ProjectDownloadService {


    /**
     * 下载项目为 ZIP 文件
     *
     * @param projectPath       项目路径
     * @param downloadFileName 下载文件名
     * @param response         HttpServletResponse
     */
    void downloadProjectAsZip(String projectPath, String downloadFileName, HttpServletResponse response);
}

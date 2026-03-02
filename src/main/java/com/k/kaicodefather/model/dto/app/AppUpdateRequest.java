package com.k.kaicodefather.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 修改应用请求
 *
 * @author KuangZixian
 */
@Data
public class AppUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String appName;

    private static final long serialVersionUID = 1L;
}

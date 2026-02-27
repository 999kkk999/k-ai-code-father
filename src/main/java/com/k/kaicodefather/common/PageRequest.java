package com.k.kaicodefather.common;

import lombok.Data;

/**
 * ClassName: PageRequest
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/2/27 18:03
 * @Version 1.0
 */

/**
 * 请求包装类（分页）
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private int pageNum = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认降序）
     */
    private String sortOrder = "descend";
}


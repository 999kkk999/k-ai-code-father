package com.k.kaicodefather.common;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: DeleteRequest
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/2/27 18:03
 * @Version 1.0
 */

/**
 * 请求包装类（删除）
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}


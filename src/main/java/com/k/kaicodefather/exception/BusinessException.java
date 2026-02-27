package com.k.kaicodefather.exception;

import lombok.Getter;

/**
 * ClassName: BusinessException
 * Description:
 *
 * @Author kzxStart
 * @Create 2026/2/27 17:44
 * @Version 1.0
 */

/**
 * 自定义异常
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}


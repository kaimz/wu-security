package com.wuwii.exception;

import com.wuwii.enums.ErrorCodeEnum;
import lombok.Getter;

/**
 * Created by KronChan on 2018/4/25 8:31.
 */
@Getter
public class BusinessException extends RuntimeException {
    /**
     * 异常码
     */
    private int code;

    private String msg;

    public BusinessException() {
    }

    public BusinessException(int code) {
        this.code = code;
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
    }
}

package com.wuwii.exception;

/**
 * Created by KronChan on 2018/4/25 8:31.
 */
public class BusinessException extends RuntimeException {
    /**
     * 异常码
     */
    protected int code;

    public BusinessException() {
    }

    public BusinessException(int code) {
        this.code = code;
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}

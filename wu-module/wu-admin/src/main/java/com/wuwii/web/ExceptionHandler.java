package com.wuwii.web;

import com.wuwii.enums.ErrorCodeEnum;
import com.wuwii.exception.BusinessException;
import com.wuwii.wrapper.FailedWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * Created by KronChan on 2018/4/27 15:30.
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<FailedWrapper> illegalArgumentException(IllegalArgumentException e) {
        log.info("参数非法异常={}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedWrapper(ErrorCodeEnum.SYS_400));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<FailedWrapper> businessException(BusinessException e) {
        log.debug("业务异常={}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailedWrapper(e));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<FailedWrapper> accessDeniedException(AccessDeniedException e) {
        log.debug("没有权限={}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new FailedWrapper(ErrorCodeEnum.SYS_403));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<FailedWrapper> exception(Exception e) {
        log.error("系统出现错误={}", e.getMessage(), e);
        // todo 记录到日志数据库
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FailedWrapper(ErrorCodeEnum.SYS_500));
    }

}

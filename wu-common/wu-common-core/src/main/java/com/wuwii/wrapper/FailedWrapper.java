package com.wuwii.wrapper;

import com.wuwii.enums.ErrorCodeEnum;
import com.wuwii.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * The response returns the failed message
 *
 * Created by KronChan on 2018/4/27 15:01.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FailedWrapper implements Serializable {

    private int code;

    private String msg;


    public FailedWrapper(ErrorCodeEnum errorCodeEnum) {
        code = errorCodeEnum.getCode();
        msg = errorCodeEnum.getMsg();
    }

    public FailedWrapper(BusinessException e) {
        code = e.getCode();
        msg = e.getMsg();
    }

}

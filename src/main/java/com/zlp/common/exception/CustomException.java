package com.zlp.common.exception;

import com.zlp.common.api.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 自定义异常
 * @date: 2021/3/11 16:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

    /**
     * 状态码
     */
    private final Long code;

    /**
     * 方法名称
     */
    private final String method;

    /**
     * 自定义异常
     *
     * @param resultEnum 返回枚举对象
     * @param method     方法
     */
    public CustomException(ResultCode resultEnum, String method) {

        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
        this.method = method;
    }

    /**
     * @param code    状态码
     * @param message 错误信息
     * @param method  方法
     */
    public CustomException(Long code, String message, String method) {

        super(message);
        this.code = code;
        this.method = method;
    }

}
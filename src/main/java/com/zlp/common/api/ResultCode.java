package com.zlp.common.api;


/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {

    /**
     * 通用异常信息
     */
    UNKNOWN_EXCEPTION(100, "未知异常"),
    FORMAT_ERROR(101, "参数格式错误"),
    TIME_OUT(102, "超时"),
    ADD_ERROR(103, "添加失败"),
    UPDATE_ERROR(104, "更新失败"),
    DELETE_ERROR(105, "删除失败"),
    GET_ERROR(106, "查找失败"),
    ARGUMENT_TYPE_MISMATCH(107, "参数类型不匹配"),
    REQ_METHOD_NOT_SUPPORT(110,"请求方式不支持"),
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    
    
    
    /** 
     * 10000 系统模块
     */
    SYS_10001(10001,"该用户不存在"),
    SYS_10002(10002,"用户名或密码错误"),
    SYS_10003(10003,"用户ID未找到相对应的用户信息")


    ;

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过状态码获取枚举对象
     * @param code 状态码
     * @return 枚举对象
     */
    public static ResultCode getByCode(Long code){

        for (ResultCode resultCode : ResultCode.values()) {
            if(code == resultCode.getCode()){
                return resultCode;
            }
        }
        return null;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

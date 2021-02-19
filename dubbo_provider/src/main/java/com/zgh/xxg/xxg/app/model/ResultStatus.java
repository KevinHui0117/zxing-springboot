package com.zgh.xxg.xxg.app.model;

/**
 * 系统返回码
 * @author huikai
 * @since 2020-04-01 17:23:47
 */
public enum ResultStatus {
    SUCCESS(1, "请求成功"),
    FAIL(0, "请求失败"),
    SYS_ERROR(500, "系统错误！"),
    OPERATION_ERROR(501, "业务逻辑错误！"),
    TRANSFER_ERROR(500, "调用改接口页面！");
    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultStatus(int code, String message,String msgExt) {
        this.code = code;
        this.message = message + msgExt ;
    }

    public int getCode() {
        return code;
    }

    public String getStringCode() {
        return String.valueOf(code);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

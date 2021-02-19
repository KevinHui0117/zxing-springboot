package com.zgh.xxg.xxg.app.model;


/**
 * Json数据返回基类
 * @author huikai
 * @since 2020-04-01 17:23:47
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBean<T>  {
    /**
     * 状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;

    public ResponseBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResponseBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public ResponseBean(ResultStatus resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.msg = resultStatus.getMessage();
        this.data = data;
    }

    public ResponseBean(ResultStatus resultStatus, T data, String locale) {
        this.code = resultStatus.getCode();
        this.msg = MessageSourceUtil.getMessage("1", locale);
        this.data = data;
    }

    public static ResponseBean ok() {
        return new ResponseBean(ResultStatus.SUCCESS, null);
    }

    public static ResponseBean suc(Object data) {
        return new ResponseBean(ResultStatus.SUCCESS.getCode(), ResultStatus.SUCCESS.getMessage(), data);
    }

    public static ResponseBean error(Object data) {
        return new ResponseBean(ResultStatus.FAIL.getCode(), ResultStatus.FAIL.getMessage(), data);
    }

    public static ResponseBean error(ResultStatus error) {
        return new ResponseBean(error, null);
    }


    public static ResponseBean error(ResultStatus error, Object data) {
        return new ResponseBean(error, data);
    }

    public static ResponseBean error(int code, String msg, Object data) {
        return new ResponseBean(code, msg, data);
    }

    public static ResponseBean result(boolean result, Object data) {
        ResultStatus resultStatus = result ? ResultStatus.SUCCESS : ResultStatus.FAIL;
        return new ResponseBean(resultStatus.getCode(), resultStatus.getMessage(), data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

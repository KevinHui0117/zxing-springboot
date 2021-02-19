package com.zgh.business.entity;

import lombok.Data;

/**
 * 二维码生成请求参数
 */
@Data
public class GenQrcodeReq {
    /**
     * 二维码 业务链接地址
     */
    private String codeLink;
    /**
     * 二维码类型 1：静态码；2：跳转活码
     */
    private int codeLinkType;
    /**
     * 二维码大小
     */
    private int codeSize = 400;
    /**
     * 类型  1:动态码；2：静态码
     */
    private String codeType;
    /**
     * 生效日期 yyyy-MM-dd
     */
    private String effectiveDate;
    /**
     * 失效日期 yyyy-MM-dd
     */
    private String expirationDate;
}

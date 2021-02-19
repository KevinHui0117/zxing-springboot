package com.zgh.business.entity;


import lombok.Data;

/**
 * 二维码生成返回参数
 * @author huik
 * @since 2020-09-16 16:42
 */
@Data
public class QrCodeResp {
    private String codeId;
    private String codePicId;
    private String httpCodeAddr;
}

package com.zgh.business.service;


import java.util.Map;

/**
 * 二维码管理服务类
 * @author huikai
 * @date 2020-01-28 10:47
 */

public interface QrCodeServiceI {
    /**
     * 生成二维码 参数均为必传
     *
     * @param reqMap (
     *               genChannel:生成渠道（eg:App/personalCenter）
     *               codeLink:跳转链接；
     *               codeLinkType:二维码链接类型 1：静态码；2：跳转活码;
     *               codeSize:二维码图片大小;
     *               codeType:类型  1:动态码；2：静态码;
     *               effectiveDate:生效日期 yyyy-MM-dd HH:mm:ss;
     *               expirationDate:失效日期 yyyy-MM-dd HH:mm:ss
     *               )
     */
    Map<String,Object> produceQrCode(Map<String,Object> reqMap);
    /**
     * 校验二维码 参数均为必传
     * @param codeId 二维码配置编号
     * @param codePicId 二维码生成的图片的编号
     * @param operateMark 二维码的业务标志
     */
    Map<String,Object> ScanCodeVerification(String codeId, String codePicId, String operateMark);


}

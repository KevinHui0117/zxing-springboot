package com.zgh.business.entity;

import com.zgh.xxg.xxg.base.module.BaseEntity;
import lombok.Data;

import java.io.Serializable;


/**
 * 二维码生成记录表(TSysQrcode)实体类
 *
 * @author huikai
 * @since 2021-01-12 16:34:47
 */
@Data
public class TSysQrcode extends BaseEntity implements Serializable {
    /**
     * 二维码名称
     */
    private String codeName = "";
    /**
     * 类型  1:动态码；2：静态码
     */
    private String codeType = "";
    /**
     * 更新频率  todo 默认设置每5分钟更新一次
     */
    private int refreshFrequency = 5;
    /**
     * 更新频率 1：秒；2：分钟；3：小时；4：天
     */
    private int frequencyUnit = 2;
    /**
     * 分类 1：普通二维码；2：渠道二维码 3:系统二维码
     */
    private int codeClassification = 0;
    /**
     * 生效日期 yyyy-MM-dd HH:mm:ss
     */
    private String effectiveDate;
    /**
     * 失效日期 yyyy-MM-dd HH:mm:ss
     */
    private String expirationDate;
    /**
     * 渲染模式 1：canvas; 2:image; 3:div
     */
    private int renderMode = 2;
    /**
     * LOGO的高度
     */
    private int logoHeight = 80;
    /**
     * 二维码颜色
     */
//    private int codeColor = RgbUtil.toIntFromColorCode("#000000");
    private String codeColor = "#000000";
    /**
     * 二维码背景颜色
     */
//    private int codeBgdColor = RgbUtil.toIntFromColorCode("#ffffff");
    private String codeBgdColor = "#ffffff";
    /**
     * 二维码文字颜色
     */
//    private int codeFontColor = RgbUtil.toIntFromColorCode("#000000");
    private String codeFontColor = "#ffffff";
    /**
     * 识别度
     */
    private int recognitionDgree;
    /**
     * 密度
     */
    private int density;
    /**
     * LOGO的fdfs地址
     */
    private String logoAddr = "";
    /**
     * LOGO的宽度
     */
    private int logoWidth = 80;
    /**
     * 二维码下的文字
     */
    private String logoWord = "";
    /**
     * 二维码下的文字大小
     */
    private int logoWordSize = 12;
    /**
     * 二维码文字颜色
     */
    private String logoWordColor= "#ffffff";
    /**
     * 二维码信息-文本
     */
    private String codeTextarea = "";
    /**
     * 二维码链接地址
     */
    private String codeLink = "";
    /**
     * 二维码链接类型 1：静态码；2：跳转活码
     */
    private int codeLinkType;
    /**
     * 短网址
     */
    private String codeShortLink = "";

    /**
     * 是否启用，系统二维码；0否1是
     */
    private String enable = "";
    /**
     * 二维码大小
     */
    private int codeSize = 400;
    /**
     * 生成的二维码的地址
     */
    private String codeAddr = "";
    /**
     * 是否是平台二维码 0：否；1：是 ; 默认为 0
     */
    private String isPlatformQr = "0";

    // ----------------------------------------------------以下不入库：-----------------------------------------------
    /**
     * 统计扫描数量，仅展示
     */
    private int scanCount;
    /**
     * 判断为哪种下载类型，仅展示 0 为正常生成；其他为下载生成
     *
     * @descript {"PngFormat":"1,2,3","VectorFormat":"4,5,6"} ==> 1,2,3使用png格式，含有美化的样式; 4,5,6不含美化样式
     */
    private String downModeStr = "0";
    /**
     * 二维码格式 jpg/png
     */
    private String format = "jpg";
    /**
     * 修改or新增 1：修改；2：详情
     */
    private String status = "0";
    /**
     * 二维码图片唯一标志
     */
    private String codePicId = "";
    /**
     * 是否是扫码过期校验 默认 0：否；1：是
     */
    private int isRefreshValidate = 0;
}
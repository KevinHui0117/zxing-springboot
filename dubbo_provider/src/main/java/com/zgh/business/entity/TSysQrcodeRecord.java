package com.zgh.business.entity;

import com.zgh.xxg.xxg.base.module.BaseEntity;
import lombok.Data;

import java.io.Serializable;


/**
 * 二维码扫描明细表(TSysQrcodeRecord)实体类
 *
 * @author huikai
 * @since 2021-01-20 09:42:01
 */
@Data
public class TSysQrcodeRecord extends BaseEntity implements Serializable {

    /**
     * 二维码ID
     */
    private long codeId;
    /**
     * 用户ID
     */
    private long userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话
     */
    private String phone;
    /**
     * 所属工会
     */
    private Long labourUnionId;
    // ----------------------------------------------------以下不入库：-----------------------------------------------
    /**
     * 所属工会名称
     */
    private String labourUnionName;
    /**
     * 所属工会隶属工会,仅展示
     */
    private String belongLabourUnion;



}
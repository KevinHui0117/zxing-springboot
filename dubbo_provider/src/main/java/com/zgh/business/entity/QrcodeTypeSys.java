package com.zgh.business.entity;

import com.zgh.xxg.xxg.base.module.BaseEntity;
import lombok.Data;

import java.io.Serializable;


/**
 * 系统二维码实体类
 *
 * @author chenwl
 * @since 2021-01-12 16:34:47
 */
@Data
public class QrcodeTypeSys extends BaseEntity implements Serializable {
    /**
     * 二维码名称
     */
    private String codeName;
    /**
     * 类型  1:动态码；2：静态码
     */
    private int codeType;
    /**
     * 更新频率
     */
    private Integer refreshFrequency;
    /**
     * 更新频率 1：秒；2：分钟；3：小时；4：天
     */
    private Integer frequencyUnit;
    /**
     * 分类 1：普通二维码；2：渠道二维码 3:系统二维码
     */
    private int codeClassification;
    /**
     * 生效日期 yyyy-MM-dd
     */
    private String effectiveDate;
    /**
     * 失效日期 yyyy-MM-dd
     */
    private String expirationDate;
    /**
     * 是否启用，系统二维码；0否1是
     */
    private String enable;
}
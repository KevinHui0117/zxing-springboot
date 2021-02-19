package com.zgh.xxg.xxg.base.module;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xpc
 * @since 2020-11-03
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
@KeySequence("SEQ_TUS_LABOURUNIONANDCOM")
  @TableName("TUS_LABOURUNIONANDCOM")

public class TusLabourunionandcomVO extends PourEntity {

    private static final long serialVersionUID = 1L;

    public TusLabourunionandcomVO() {
    }

    public TusLabourunionandcomVO(Operater operater) {
        super(operater);
    }

    @TableId(value = "ID", type = IdType.INPUT)
      private Long id;

      @TableField("LABOURUNIONID")
      private Long labourUnionId;  //工会ID

    /**
     * 删除为0
     * 正常为1
     * 与DELETED同步，非mp体系，照样查status即可。
     */
    @TableField("STATUS")
    private String status;

      @TableField("LINKTYPE")
      private String linkType;

      @TableField("STARTTIME")
      private String startTime;

      @TableField("ENDTIME")
      private String endTime;

    @TableField("COMPANYID")
    private Long companyId;		//单位ID



    //以下信息不存数据库
    @TableField(exist = false)
    private String labourUnionName;
    @TableField(exist = false)
    private String companyName;		//单位名称
    @TableField(exist = false)
    private String companyMean;		//单位属性
    @TableField(exist = false)
    private String companyUnifiedCode;		//单位统一社会信用代码
    @TableField(exist = false)
    private String companyCreateTime;		//成立日期
    @TableField(exist = false)
    private String companyLawPerson;		//单位法人代表
    @TableField(exist = false)
    private String companyLawPersonIdCardType;		//法人代表证件类型
    @TableField(exist = false)
    private String companyLawPersonIdCardCode;		//法人代表证件号码
    @TableField(exist = false)
    private String companyNature;		//单位性质类别
    @TableField(exist = false)
    private String companyIndustry;		//单位所属行业
    @TableField(exist = false)
    private String companyRegAddress;		//单位注册地址
    @TableField(exist = false)
    private String companyRealAddress;		//单位实际经营地址
    @TableField(exist = false)
    private String companyProvince;		//单位所在省
    @TableField(exist = false)
    private String companyCity;		//单位所在市
    @TableField(exist = false)
    private String companyArea;		//单位所在区
    @TableField(exist = false)
    private String companyStreet;		//单位所在镇街
    @TableField(exist = false)
    private String companyType;		//单位经济类型
    @TableField(exist = false)
    private String companyTel;		//单位联系电话
    @TableField(exist = false)
    private String companyPostcode;		//单位邮编
    @TableField(exist = false)
    private String partyStatus;		//党组织建立情况
    @TableField(exist = false)
    private String  companyProvinceShow;
    @TableField(exist = false)
    private String  companyCityShow;
    @TableField(exist = false)
    private String  companyAreaShow;
    @TableField(exist = false)
    private String  companyStreetShow;
    @TableField(exist = false)
    private String 	companyNatureName;
    @TableField(exist = false)
    private String 	companyIndustryName;
    @TableField(exist = false)
    private String 	companyTypeName;
    @TableField(exist = false)
    private String 	companyMeanName;
    @TableField(exist = false)
    private String  companyLawPersonIdCardTypeName;
    @TableField(exist = false)
    private String companyStatus;	//单位状态
    @TableField(exist = false)
    private String groups;//所属群体--工会会员系统-入会申请时所需-数据字典
    @TableField(exist = false)
    private String companyproperty; //单位属性


      public static final String ID = "ID";

      public static final String LABOURUNIONID = "LABOURUNIONID";

      public static final String STATUS = "STATUS";

      public static final String LINKTYPE = "LINKTYPE";

      public static final String STARTTIME = "STARTTIME";

      public static final String ENDTIME = "ENDTIME";

      public static final String COMPANYID = "COMPANYID";

  }

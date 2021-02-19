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
 * @since 2020-11-24
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
@KeySequence("SEQ_TUS_COMPANY")
  @TableName("TUS_COMPANY")
public class TusCompanyVO extends PourEntity {

    private static final long serialVersionUID = 1L;

    public TusCompanyVO() {
    }

    public TusCompanyVO(Operater operater) {
        super(operater);
    }

    @TableId(value = "ID", type = IdType.INPUT)
      private Long id;

    @TableField(value = "COMPANYNAME",condition = SqlConditionPlus.LIKE)
    private String companyName;

    @TableField("COMPANYMEAN")
    private String companyMean;

    @TableField("COMPANYUNIFIEDCODE")
    private String companyUnifiedCode;

    @TableField("COMPANYCREATETIME")
    private String companyCreateTime;		//成立日期

    @TableField("COMPANYLAWPERSON")
    private String companyLawPerson;		//单位法人代表

    @TableField("COMPANYINDUSTRY")
    private String companyIndustry;		//单位所属行业

    @TableField("COMPANYNATURE")
    private String companyNature;		//单位性质类别

    @TableField("COMPANYTYPE")
    private String companyType;		//单位经济类型

    @TableField("COMPANYPOSTCODE")
    private String companyPostcode;		//单位邮编

    @TableField("COMPANYREGADDRESS")
    private String companyRegAddress;		//单位注册地址

    @TableField("COMPANYREALADDRESS")
    private String companyRealAddress;		//单位实际经营地址

    @TableField("COMPANYPROVINCE")
    private String companyProvince;		//单位所在省

    @TableField("COMPANYCITY")
    private String companyCity;		//单位所在市

    @TableField("COMPANYAREA")
    private String companyArea;		//单位所在区

    @TableField("COMPANYSTREET")
    private String companyStreet;		//单位所在镇街

    @TableField("PARTYSTATUS")
    private String partyStatus;		//党组织建立情况  1党支部 2党委 3党小组

    @TableField("COMPANYLAWPERSONIDCARDTYPE")
    private String companyLawPersonIdCardType;		//法人代表证件类型

    @TableField("COMPANYLAWPERSONIDCARDCODE")
    private String companyLawPersonIdCardCode;		//法人代表证件号码

    @TableField("COMPANYTEL")
    private String companyTel;		//单位联系电话

      /**
     * 0被删除，1正常
     */
      @TableField("COMPANYSTATUS")
      private String companyStatus;

    @TableField("GROUPS")
    private String groups;//所属群体--工会会员系统-入会申请时所需-数据字典
    @TableField("COMPANYPROPERTY")
    private String companyproperty; //单位属性

    //以下信息不存数据库，仅作展现使用
    @TableField(exist = false)
    private long labourUnionId;	//所属工会ID
    @TableField(exist = false)
    private String labourUnionName;	//所属工会名称
    @TableField(exist = false)
    private long parentId; 	//上级工会ID
    @TableField(exist = false)
    private String parentName;	//上级工会名称
    @TableField(exist = false)
    private String priorEstablishUnionPeople;	//优先建会

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



      public static final String ID = "ID";

      public static final String COMPANYNAME = "COMPANYNAME";

      public static final String COMPANYMEAN = "COMPANYMEAN";

      public static final String COMPANYUNIFIEDCODE = "COMPANYUNIFIEDCODE";

      public static final String COMPANYCREATETIME = "COMPANYCREATETIME";

      public static final String COMPANYLAWPERSON = "COMPANYLAWPERSON";

      public static final String COMPANYINDUSTRY = "COMPANYINDUSTRY";

      public static final String COMPANYNATURE = "COMPANYNATURE";

      public static final String COMPANYTYPE = "COMPANYTYPE";

      public static final String COMPANYPOSTCODE = "COMPANYPOSTCODE";

      public static final String COMPANYREGADDRESS = "COMPANYREGADDRESS";

      public static final String COMPANYREALADDRESS = "COMPANYREALADDRESS";

      public static final String COMPANYPROVINCE = "COMPANYPROVINCE";

      public static final String COMPANYCITY = "COMPANYCITY";

      public static final String COMPANYAREA = "COMPANYAREA";

      public static final String COMPANYSTREET = "COMPANYSTREET";

      public static final String PARTYSTATUS = "PARTYSTATUS";

      public static final String COMPANYLAWPERSONIDCARDTYPE = "COMPANYLAWPERSONIDCARDTYPE";

      public static final String COMPANYLAWPERSONIDCARDCODE = "COMPANYLAWPERSONIDCARDCODE";

      public static final String COMPANYTEL = "COMPANYTEL";

      public static final String COMPANYSTATUS = "COMPANYSTATUS";

      public static final String GROUPS = "GROUPS";

  }

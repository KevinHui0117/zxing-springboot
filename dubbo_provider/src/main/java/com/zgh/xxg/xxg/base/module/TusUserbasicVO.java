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
 * @since 2020-12-09
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
@KeySequence("SEQ_TUS_USERBASIC")
  @TableName("TUS_USERBASIC")
public class TusUserbasicVO extends PourEntity {

    private static final long serialVersionUID = 1L;

    public TusUserbasicVO() {
    }

    public TusUserbasicVO(Operater operater) {
        super(operater);
    }

    /**
     * 
     */
        @TableId(value = "ID", type = IdType.INPUT)
      private Long id;

      /**
     * 用户id
     */
      @TableField("USERID")
    private Long userId;

      /**
     * 婚姻状态
     */
      @TableField("MARRY")
      private String marry;		//婚姻状态

      /**
     * 国籍
     */
      @TableField("COUNTRY")
      private String country;		//国籍

      /**
     * 民族
     */
      @TableField("NATION")
    private String nation;

      /**
     * 户籍类型
     */
      @TableField("ADDRESSTYPE")
      private String addressType;		//户籍类型

      /**
     * 户籍-省,包括直辖市 
     */
      @TableField("PROVINCE")
    private String province;

      /**
     * 户籍-地市，如果是直辖市，此处为区
     */
      @TableField("CITY")
    private String city;

      /**
     * 户籍-区，如果是直辖市，此处为街道
     */
      @TableField("AREA")
    private String area;

      /**
     * 住址
     */
      @TableField("ADDRESS")
    private String address;

      /**
     * 照片地址
     */
      @TableField("PHOTOADDRESS")
      private String photoAddress;	//照片地址

      /**
     * 生育状态
     */
      @TableField("BIRTHSTATUS")
      private String birthStatus;		//生育状态

      /**
     * 子女个数
     */
      @TableField("CHILDNUMBER")
    private Integer childNumber;

      /**
     * 健康状态
     */
      @TableField("HEALTH")
    private String health;

      /**
     * 政治面貌
     */
      @TableField("POLITICS")
    private String politics;

      /**
     * 岗位状态
     */
      @TableField("STATIONSTATUS")
    private String stationStatus;

      /**
     * 学历
     */
      @TableField("EDUCATION")
    private String education;

      /**
     * 技术等级
     */
      @TableField("SKILLLEVEL")
    private String skillLevel;

      /**
     * 就业状态
     */
      @TableField("WORKSTATUS")
    private String workStatus;

      /**
     * 职务
     */
      @TableField("JOB")
    private String job;

      /**
     * 职称
     */
      @TableField("JOBLEVEL")
    private String jobLevel;

      /**
     * 参加工作时间
     */
      @TableField("WORKSTARTTIME")
      private String workStartTime;		//参加工作时间

      /**
     * 职级 --oa系统专有
     */
      @TableField("JOBRANK")
    private String jobRank;

      /**
     * 结婚年份-2010
     */
      @TableField("MARRYTIME")
      private String marryTime;	//结婚时间

      /**
     * 头像地址
     */
      @TableField("AVATAR")
    private String avatar;

      /**
     * 数据来源
     */
      @TableField("DATASOURCE")
    private String dataSource;

      /**
     * 现居地-省
     */
      @TableField("NOWPROVINCE")
      private String nowProvince;		//现居地-省,包括直辖市

      /**
     * 现居地-城市
     */
      @TableField("NOWCITY")
      private String nowCity;		//现居地-地市，


    /**
     * 现居地-区/县
     */
      @TableField("NOWAREA")
      private String nowArea;		//现居地-区，

      /**
     * 现居地-街道
     */
      @TableField("NOWSTREET")
      private String nowStreet;     //现居地 - 街道

      /**
     * 学位
     */
      @TableField("DEGREE")
    private String degree;


      public static final String ID = "ID";

      public static final String USERID = "USERID";

      public static final String MARRY = "MARRY";

      public static final String COUNTRY = "COUNTRY";

      public static final String NATION = "NATION";

      public static final String ADDRESSTYPE = "ADDRESSTYPE";

      public static final String PROVINCE = "PROVINCE";

      public static final String CITY = "CITY";

      public static final String AREA = "AREA";

      public static final String ADDRESS = "ADDRESS";

      public static final String PHOTOADDRESS = "PHOTOADDRESS";

      public static final String BIRTHSTATUS = "BIRTHSTATUS";

      public static final String CHILDNUMBER = "CHILDNUMBER";

      public static final String HEALTH = "HEALTH";

      public static final String POLITICS = "POLITICS";

      public static final String STATIONSTATUS = "STATIONSTATUS";

      public static final String EDUCATION = "EDUCATION";

      public static final String SKILLLEVEL = "SKILLLEVEL";

      public static final String WORKSTATUS = "WORKSTATUS";

      public static final String JOB = "JOB";

      public static final String JOBLEVEL = "JOBLEVEL";

      public static final String WORKSTARTTIME = "WORKSTARTTIME";

      public static final String JOBRANK = "JOBRANK";

      public static final String MARRYTIME = "MARRYTIME";

      public static final String AVATAR = "AVATAR";

      public static final String DATASOURCE = "DATASOURCE";

      public static final String NOWPROVINCE = "NOWPROVINCE";

      public static final String NOWCITY = "NOWCITY";

      public static final String NOWAREA = "NOWAREA";

      public static final String NOWSTREET = "NOWSTREET";

      public static final String DEGREE = "DEGREE";

  }

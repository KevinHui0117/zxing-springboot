package com.zgh.xxg.xxg.base.module;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xpc
 * @since 2020-12-24
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
  @TableName("TUS_USER")
public class TusUserVO extends PourEntity {

    private static final long serialVersionUID = 1L;

      /**
     * 用户id
     */
        @TableId(value = "ID", type = IdType.ASSIGN_ID)
      private Long id;

      /**
     * 姓名
     */
      @TableField("FULLNAME")
    private String fullname;

      /**
     * 拼音
     */
      @TableField("PINYIN")
    private String pinyin;

      /**
     * 拼音缩写
     */
      @TableField("PINYINABBR")
    private String pinyinabbr;

      /**
     * 证件类型
     */
      @TableField("IDCARDTYPE")
    private String idcardtype;

      /**
     * 证件号码
     */
      @TableField("IDCARDCODE")
    private String idcardcode;

      /**
     * 证件有效期开始日期
     */
      @TableField("IDCARDSTARTDATE")
    private String idcardstartdate;

      /**
     * 证件有效期结束日期
     */
      @TableField("IDCARDENDDATE")
    private String idcardenddate;

      /**
     * 生日
     */
      @TableField("BIRTHDAY")
    private String birthday;

      /**
     * 性别
     */
      @TableField("SEX")
    private String sex;

      /**
     * 用户名
     */
      @TableField("USERNAME")
    private String username;

      /**
     * 手机号
     */
      @TableField("MOBILE")
    private String mobile;

      /**
     * 邮箱
     */
      @TableField("EMAIL")
    private String email;

      /**
     * 密码
     */
      @TableField("PWD")
    private String pwd;

      /**
     * 状态：1正常2锁定0注销
     */
      @TableField("STATUS")
    private String status;

      /**
     * 实名认证级别
     */
      @TableField("CERTIFICATIONLEVEL")
    private String certificationlevel;

      /**
     * 是否工会会员：
     */
      @TableField("IFMEMBER")
    private String ifmember;

      /**
     * 用户类型：1用户2工会会员
     */
      @TableField("USERTYPE")
    private String usertype;

      /**
     * 密码错误次数
     */
      @TableField("PASSWORDERRORNUMBER")
    private Integer passworderrornumber;

      /**
     * 最后一次登录时间
     */
      @TableField("LASTLOGINTIME")
    private String lastlogintime;

      /**
     * 主要信息更新时间
     */
      @TableField("MAININFOUPDATETIME")
    private String maininfoupdatetime;

    @TableField("MYID")
    private String myid;

    @TableField("WIID")
    private String wiid;

    @TableField("MYPARENTID")
    private String myparentid;

    @TableField("FORMID")
    private String formid;

    @TableField("BUSINESSKEY")
    private String businesskey;

      /**
     * 即时通讯号码
     */
      @TableField("IMNO")
    private String imno;

    @TableField("GROUPS")
    private String groups;

    @TableField("MEMBERSTATUS")
    private String memberstatus;


      public static final String ID = "ID";

      public static final String FULLNAME = "FULLNAME";

      public static final String PINYIN = "PINYIN";

      public static final String PINYINABBR = "PINYINABBR";

      public static final String IDCARDTYPE = "IDCARDTYPE";

      public static final String IDCARDCODE = "IDCARDCODE";

      public static final String IDCARDSTARTDATE = "IDCARDSTARTDATE";

      public static final String IDCARDENDDATE = "IDCARDENDDATE";

      public static final String BIRTHDAY = "BIRTHDAY";

      public static final String SEX = "SEX";

      public static final String USERNAME = "USERNAME";

      public static final String MOBILE = "MOBILE";

      public static final String EMAIL = "EMAIL";

      public static final String PWD = "PWD";

      public static final String STATUS = "STATUS";

      public static final String CERTIFICATIONLEVEL = "CERTIFICATIONLEVEL";

      public static final String IFMEMBER = "IFMEMBER";

      public static final String USERTYPE = "USERTYPE";

      public static final String PASSWORDERRORNUMBER = "PASSWORDERRORNUMBER";

      public static final String LASTLOGINTIME = "LASTLOGINTIME";

      public static final String MAININFOUPDATETIME = "MAININFOUPDATETIME";

      public static final String MYID = "MYID";

      public static final String WIID = "WIID";

      public static final String MYPARENTID = "MYPARENTID";

      public static final String FORMID = "FORMID";

      public static final String BUSINESSKEY = "BUSINESSKEY";

      public static final String IMNO = "IMNO";

      public static final String GROUPS = "GROUPS";

      public static final String MEMBERSTATUS = "MEMBERSTATUS";

  }

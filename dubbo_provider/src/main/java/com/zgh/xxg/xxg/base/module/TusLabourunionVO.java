package com.zgh.xxg.xxg.base.module;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author xpc
 * @since 2020-11-30
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
  @TableName("TUS_LABOURUNION")
public class TusLabourunionVO extends PourEntity {

    private static final long serialVersionUID = 1L;

    public TusLabourunionVO() {}

    public TusLabourunionVO(Operater operater) {
        super(operater);
    }

    @TableId(value = "ID", type = IdType.INPUT)
      private Long id;

    //condition就算设置了like。Map作为参数也是等于equal。只有实体VO对象传入，才会触发condition
    @TableField(value = "LABOURUNIONCODE",condition = SqlConditionPlus.LIKE,whereStrategy = FieldStrategy.NOT_EMPTY)
    private String labourUnionCode;	//工会编码（自动生成）

    @TableField(value = "LABOURUNIONNAME",condition = SqlConditionPlus.LIKE,whereStrategy = FieldStrategy.NOT_EMPTY)
    private String labourUnionName;	//工作名称

    @TableField("PWD")
    private String pwd;

    @TableField("PASSWORDERRORNUMBER")
    private Integer passwordErrorNumber;		//密码连续错误次数，只有工会法人才拥有

    @TableField("LASTLOGINTIME")
    private String lastLoginTime;		//最后登录时间，只有工会法人才拥有

    @TableField("PINYIN")
    private String pinyin;

    @TableField("PINYINABBR")
    private String pinyinAbbr;		//拼音缩写

    @TableField("EMPLOYEENUMBER")
    private Integer employeeNumber;

    @TableField("WOMANEMPLOYEENUMBER")
    private Integer womanEmployeeNumber;

    @TableField("MEMBERNUMBER")
    private Integer memberNumber;

    @TableField("WOMANMEMBERNUMBER")
    private Integer womanMemberNumber;

    @TableField("CADRENUMBER")
    private Integer cadreNumber;

    @TableField("OTHERCADRENUMBER")
    private Integer otherCadreNumber;

    @TableField("FARMERNUMBER")
    private Integer farmerNumber;

    @TableField("POORNUMBER")
    private Integer poorNumber;

    @TableField(value = "LABOURUNIONUNIFIEDCODE", condition = SqlConditionPlus.LIKE,whereStrategy = FieldStrategy.NOT_EMPTY)
    private String labourUnionUnifiedCode;		//工会社会信用代码

    @TableField("LABOURUNIONTYPE")
    private String labourUnionType;		//工会类型

    @TableField("LABOURUNIONSTATUS")
    private LabourUnionStatusEnum labourUnionStatus;		//工会状态

    @TableField("CREATELABOURUNIONTIME")
    private String createLabourUnionTime; 		//建会时间

    @TableField("LINKMAN")
    private String linkMan;		//联系人

    @TableField("LINKTEL")
    private String linkTel;		//联系电话

    @TableField("LINKEMAIL")
    private String linkEmail;  //联系邮箱

    @TableField("CHAIRMAN")
    private String chairman;

    @TableField("CHAIRMANTEL")
    private String chairmanTel;			//工会主席联系电话

    @TableField("CHAIRMANSTARTTIME")
    private String chairmanStartTime;	//工会主席任期开始时间

    @TableField("CHAIRMANENDTIME")
    private String chairmanEndTime;		//工会主席任期结束时间

    @TableField("IFSERVICESTATION")
    private String ifServiceStation;	//是否工会服务站

    @TableField("IFCREATESEAL")
    private String ifCreateSeal;		//是否有公章

    @TableField("IFCREATEBANK")
    private String ifCreateBank;		//是否开设银行对公账户

    @TableField("BANKCODE")
    private String bankCode;			//银行账户

    @TableField("IFCREATEFEECHECK")
    private String ifCreateFeeCheck; 	//是否建立经费审查委员会

    @TableField("FEECHECKCHAIRMAN")
    private String feeCheckChairman;	//经审会主席

    @TableField("FEECHECKTEL")
    private String feeCheckTel;			//经审会联系电话

    @TableField("FEECHECKMEMBERS")
    private String feeCheckMembers;		//经审会委员

    @TableField("IFCREATEWOMEN")
    private String ifCreateWomen;		//是否建立女职工委员会

    @TableField("WOMENCHAIRMAN")
    private String womenChairman;		//女工委主任

    @TableField("WOMENTEL")
    private String womenTel;			//女工委联系电话

    @TableField("WOMENMEMBERS")
    private String womenMembers;		//女工委委员

    @TableField("IFCREATESTAFF")
    private String ifCreateStaff;		//是否创建职工代表大会制度

    @TableField("STAFFMEMBERS")
    private String staffMembers;		//代表大会委员

    @TableField("IFCREATELABOURLAW")
    private String ifCreateLabourLaw;	//是否建立工会劳动法律监督委员会

    @TableField("LABOURLAWMEMBERS")
    private String labourLawMembers;	//劳动法律监督委员会委员

    @TableField("IFCREATEOPEN")
    private String ifCreateOpen;		//是否创建厂务公开制度

    @TableField("IFCREATECONTRACT")
    private String ifCreateContract;	//是否建立集体合同制度

    @TableField("IFJOINCARE")
    private String ifJoinCare;			//是否参与市总职工医疗互助保障

    @TableField("JOINCARENUMBER")
    private Integer joinCareNumber;

    @TableField("IFCREATEMEMBERCARD")
    private String ifCreateMemberCard;	//是否办理工会会员卡

    @TableField("MEMBERCARDNUMBER")
    private Integer memberCardNumber;

    @TableField("HOMESTAR")
    private String homeStar;

    @TableField("WININFO")
    private String winInfo;

    @TableField("MODELNUMBER")
    private Integer modelNumber;

    @TableField("LINKADDRESS")
    private String linkAddress;

    @TableField("LABOURUNIONLAWPERSON")
    private String labourUnionLawPerson;

    @TableField("CHAIRMANEMAIL")
    private String chairmanEmail;		//工会主席邮箱

    @TableField("LABOURUNIONSTARTTIME")
    private String  labourUnionStartTime;	//工会法人有效期限起

    @TableField("LABOURUNIONENDTIME")
    private String  labourUnionEndTime;	//工会法人有效期限止

    @TableField("MAININFOUPDATETIME")
    private String mainInfoUpdateTime;

    @TableField("LABOURUNIONINDUSTRY")
    private String labourUnionIndustry;		//工会所属行业

    @TableField(value = "LABOURUNIONNATURE", condition = SqlConditionPlus.LIKE,whereStrategy = FieldStrategy.NOT_EMPTY)
    private String labourUnionNature;		//工会的单位性质类别

    @TableField("LABOURUNIONPROVINCE")
    private String labourUnionProvince;		//所属行政区划信息

    @TableField("LABOURUNIONCITY")
    private String labourUnionCity;

    @TableField("LABOURUNIONAREA")
    private String labourUnionArea;

    @TableField("LABOURUNIONSTREET")
    private String labourUnionStreet;

    @TableField("LABOURUNIONLEVEL")
    private String labourunionlevel;


     // 工会组织类型：1独立基层工会 2联合基层工会 3街道工会 4园区工会 5行业工会 6集团工会 7系统工会 8分会/小组
    @TableField("LABOURUNIONORGTYPE")
    private String labourunionorgtype;	//工会组织类型 // 1独立基层工会 2联合基层工会 3街道工会 4园区工会 5行业工会 6集团工会 7系统工会 8分会/小组

    // 工会组织形式：1总工会、2工会、3工会联合会、4工会委员会、5联合工会委员会、6分会、7小组
    @TableField("LABOURUNIONORGFORM")
    private String labourunionorgform;	//工会组织形式 // 1总工会、2工会、3工会联合会、4工会委员会、5联合工会委员会、6分会、7小组

    //社区覆盖  1是 0否
    @TableField("COVER")
    private YesOrNoEnum cover;

    //法人资格办理中 1是 0否
    @TableField("LEGALPERSONHANDLE")
    private String legalpersonhandle;


    //隶属关系调整中 1是 0否
    @TableField("AFFILIATE")
    private String affiliate;

//    注销，0否，1是
    @TableField("LOGOUT")
    private String logout;
//    建会方式  选项值为：线下建会1、网上建会2。默认值为线下建会。
    @TableField(value = "CREATELABOURUNIONTYPE")
    private CreateUnionTypeEnum createlabouruniontype;

    @TableField(value = "RESPONSIBLEMAN")
    private String  responsibleman;
    @TableField(value = "RESPONSIBLEPHONE")
    private String  responsiblephone;
    @TableField(value = "RESPONSIBLEEMAIL")
    private String  responsibleemail;
    @TableField(value = "RESPONSIBLEMANID")
    private String  responsiblemanid;
    @TableField(value="CREATEPREPARETIME")
    private String  createpreparetime;//筹备组成立日期
    @TableField(value="CREATEUNIONREPLYNO")
    private String  createunionreplyno;//建会批复文号
    @TableField(value="LINKMANID")
    private String  linkmanid;// 联系人id
    @TableField(value="LABOURUNIONADDRESS")
    private String  labourunionaddress;//
    @TableField(value="LABOURUNIONPOSTCODE")
    private String  labourunionpostcode;// 工会邮政编码
    @TableField(value="LOCALUNION",condition = SqlConditionPlus.LIKE,whereStrategy = FieldStrategy.NOT_EMPTY)
    private String  localUnion;//  所属区，地方工会
    @TableField(value="LOCALUNIONID",whereStrategy = FieldStrategy.NOT_EMPTY)
    private String  localunionid;//  所属区，地方工会



//    1职工代表大会制度,2厂务公开制度,3职工董事和职工监事制度
    @TableField(value="DEMOCRACY")
    private String democracy;

    @TableField(value="NATIONALMODEL")
    private YesOrNoEnum nationalmodel;

    @TableField(value="PROVINCIALMODEL")
    private YesOrNoEnum provincialmodel;


    @TableField(value="CHAIRMANID")
    private String chairmanid;


    @TableField(value="TERMSTARTTIME")
    private String termstarttime;

    @TableField(value="TERMENDTIME")
    private String termendtime;

    @TableField(value="FALLDUENUMBER")
    private String fallduenumber;

    @TableField(value = "TEAMLEADNAME")
    private String teamleadname;
    @TableField(value = "TEAMLEADID")
    private String teamleadid;
    @TableField(value = "TEAMLEADFALLDUENUMBER")
    private String teamleadfallduenumber;
    @TableField(value = "TEAMLEADSTARTTIME")
    private String teamleadstarttime;
    @TableField(value = "TEAMLEADENDTIME")
    private String teamleadendtime;

//    工会组织 1工会委员会2经费审查会委员会3劳动法律监督委员会4女职工委员会
    @TableField(value = "LABOURUNIONORGCOMMITTEE")
    private String labourunionorgcommittee;
    @TableField(value = "COMMITTEELIST")
    private String committeelist;
    @TableField(value = "COMMITTEELISTID")
    private String committeelistid;
    @TableField(value = "COMMITTEELISTNUM")
    private String committeelistnum;

    @TableField(value = "chairviceman")
    private String  chairviceman;
    @TableField(value = "reviewman")
    private String  reviewman;
    @TableField(value = "reviewmanid")
    private String  reviewmanid;
    @TableField(value = "reviewmannum")
    private String  reviewmannum;
    @TableField(value = "laborlawsupervisionman")
    private String  laborlawsupervisionman;
    @TableField(value = "reviewmanlead")
    private String  reviewmanlead;
    @TableField(value = "reviewmanvicelead")
    private String  reviewmanvicelead;
    @TableField(value = "laborlawsupervisionmannum")
    private String  laborlawsupervisionmannum;
    @TableField(value = "laborlawsupervisionlead")
    private String  laborlawsupervisionlead;
    @TableField(value = "laborlawsupervisionvicelead")
    private String  laborlawsupervisionvicelead;
    @TableField(value = "femaleworkers")
    private String  femaleworkers;
    @TableField(value = "femaleworkersid")
    private String  femaleworkersid;
    @TableField(value = "femaleworkersnum")
    private String  femaleworkersnum;
    @TableField(value = "femaleworkerslead")
    private String  femaleworkerslead;
    @TableField(value = "femaleworkersleadid")
    private String  femaleworkersleadid;
    @TableField(value = "laborlawsupervisionviceleadid")
    private String  laborlawsupervisionviceleadid;
    @TableField(value = "laborlawsupervisionleadid")
    private String  laborlawsupervisionleadid;
    @TableField(value = "reviewmanviceleadid")
    private String  reviewmanviceleadid;
    @TableField(value = "reviewmanleadid")
    private String  reviewmanleadid;
    @TableField(value = "laborlawsupervisionmanid")
    private String  laborlawsupervisionmanid;
    @TableField(value = "chairvicemanid")
    private String  chairvicemanid;


    //以下信息不存数据库
    @TableField(exist = false)
    private List<TusLabourunionandcomVO> companys=new ArrayList<TusLabourunionandcomVO>();
    @TableField(exist = false)
    private long parentId;		//上级单位的ID
    @TableField(exist = false)
    private String parentName;	//上级单位的名称
    @TableField(exist = false)
    private String  labourunionProvinceShow;
    @TableField(exist = false)
    private String  labourunionCityShow;
    @TableField(exist = false)
    private String  labourunionAreaShow;
    @TableField(exist = false)
    private String  labourunionStreetShow;

    public static final String ID = "ID";

      public static final String LABOURUNIONCODE = "LABOURUNIONCODE";

      public static final String LABOURUNIONNAME = "LABOURUNIONNAME";

      public static final String PWD = "PWD";

      public static final String PASSWORDERRORNUMBER = "PASSWORDERRORNUMBER";

      public static final String LASTLOGINTIME = "LASTLOGINTIME";

      public static final String PINYIN = "PINYIN";

      public static final String PINYINABBR = "PINYINABBR";

      public static final String EMPLOYEENUMBER = "EMPLOYEENUMBER";

      public static final String WOMANEMPLOYEENUMBER = "WOMANEMPLOYEENUMBER";

      public static final String MEMBERNUMBER = "MEMBERNUMBER";

      public static final String WOMANMEMBERNUMBER = "WOMANMEMBERNUMBER";

      public static final String CADRENUMBER = "CADRENUMBER";

      public static final String OTHERCADRENUMBER = "OTHERCADRENUMBER";

      public static final String FARMERNUMBER = "FARMERNUMBER";

      public static final String POORNUMBER = "POORNUMBER";

      public static final String LABOURUNIONUNIFIEDCODE = "LABOURUNIONUNIFIEDCODE";

      public static final String LABOURUNIONTYPE = "LABOURUNIONTYPE";

      public static final String LABOURUNIONSTATUS = "LABOURUNIONSTATUS";

      public static final String CREATELABOURUNIONTIME = "CREATELABOURUNIONTIME";

      public static final String LINKMAN = "LINKMAN";

      public static final String LINKTEL = "LINKTEL";

      public static final String LINKEMAIL = "LINKEMAIL";

      public static final String CHAIRMAN = "CHAIRMAN";

      public static final String CHAIRMANTEL = "CHAIRMANTEL";

      public static final String CHAIRMANSTARTTIME = "CHAIRMANSTARTTIME";

      public static final String CHAIRMANENDTIME = "CHAIRMANENDTIME";

      public static final String IFSERVICESTATION = "IFSERVICESTATION";

      public static final String IFCREATESEAL = "IFCREATESEAL";

      public static final String IFCREATEBANK = "IFCREATEBANK";

      public static final String BANKCODE = "BANKCODE";

      public static final String IFCREATEFEECHECK = "IFCREATEFEECHECK";

      public static final String FEECHECKCHAIRMAN = "FEECHECKCHAIRMAN";

      public static final String FEECHECKTEL = "FEECHECKTEL";

      public static final String FEECHECKMEMBERS = "FEECHECKMEMBERS";

      public static final String IFCREATEWOMEN = "IFCREATEWOMEN";

      public static final String WOMENCHAIRMAN = "WOMENCHAIRMAN";

      public static final String WOMENTEL = "WOMENTEL";

      public static final String WOMENMEMBERS = "WOMENMEMBERS";

      public static final String IFCREATESTAFF = "IFCREATESTAFF";

      public static final String STAFFMEMBERS = "STAFFMEMBERS";

      public static final String IFCREATELABOURLAW = "IFCREATELABOURLAW";

      public static final String LABOURLAWMEMBERS = "LABOURLAWMEMBERS";

      public static final String IFCREATEOPEN = "IFCREATEOPEN";

      public static final String IFCREATECONTRACT = "IFCREATECONTRACT";

      public static final String IFJOINCARE = "IFJOINCARE";

      public static final String JOINCARENUMBER = "JOINCARENUMBER";

      public static final String IFCREATEMEMBERCARD = "IFCREATEMEMBERCARD";

      public static final String MEMBERCARDNUMBER = "MEMBERCARDNUMBER";

      public static final String HOMESTAR = "HOMESTAR";

      public static final String WININFO = "WININFO";

      public static final String MODELNUMBER = "MODELNUMBER";

      public static final String LINKADDRESS = "LINKADDRESS";

      public static final String LABOURUNIONLAWPERSON = "LABOURUNIONLAWPERSON";

      public static final String CHAIRMANEMAIL = "CHAIRMANEMAIL";

      public static final String LABOURUNIONSTARTTIME = "LABOURUNIONSTARTTIME";

      public static final String LABOURUNIONENDTIME = "LABOURUNIONENDTIME";

      public static final String MAININFOUPDATETIME = "MAININFOUPDATETIME";

      public static final String LABOURUNIONINDUSTRY = "LABOURUNIONINDUSTRY";

      public static final String LABOURUNIONNATURE = "LABOURUNIONNATURE";

      public static final String LABOURUNIONPROVINCE = "LABOURUNIONPROVINCE";

      public static final String LABOURUNIONCITY = "LABOURUNIONCITY";

      public static final String LABOURUNIONAREA = "LABOURUNIONAREA";

      public static final String LABOURUNIONSTREET = "LABOURUNIONSTREET";

      public static final String LABOURUNIONLEVEL = "LABOURUNIONLEVEL";

      public static final String LABOURUNION_ORG_TYPE = "LABOURUNION_ORG_TYPE";

  }

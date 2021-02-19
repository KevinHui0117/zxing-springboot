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
 * @since 2020-12-09
 */
@Data
  @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
@KeySequence("SEQ_TUS_ORGANIZATION")
  @TableName("TUS_ORGANIZATION")
public class TusOrganizationVO extends PourEntity {

    private static final long serialVersionUID = 1L;

    public TusOrganizationVO() {
    }

    public TusOrganizationVO(Operater operater) {
        super(operater);
    }

    @TableId(value = "ID", type = IdType.INPUT)
      private Long id;

    @TableField("ORGANIZATIONCODE")
    private String organizationCode;	//组织编码（自动生成）

    @TableField("OLDORGANIZATIONCODE")
    private String oldOrganizationCode;  //曾经使用过的编码

    @TableField("ORGANIZATIONNAME")
    private String organizationName;	//组织名称

    @TableField("ORGANIZATIONSTATUS")
    private LabourUnionStatusEnum organizationStatus;		//状态

    @TableField("ORGANIZATIONTYPE")
    private String organizationType;		//组织类型：工会ORGANIZATION_TYPE_LABOURUNION  1、业务部门ORGANIZATION_TYPE_OTHER  2

    @TableField("PARENTID")
    private Long parentId;		//上级标识

    @TableField("BIGID")
    private Long bigId;

    @TableField("LOGOUT")
    private String logout;

    //以下信息不存数据库
    @TableField(exist = false)
    private String parentName;
    @TableField(exist = false)
    private List<Organization> children=new ArrayList<Organization>();

      public static final String ID = "ID";

      public static final String ORGANIZATIONCODE = "ORGANIZATIONCODE";

      public static final String OLDORGANIZATIONCODE = "OLDORGANIZATIONCODE";

      public static final String ORGANIZATIONNAME = "ORGANIZATIONNAME";

      public static final String ORGANIZATIONSTATUS = "ORGANIZATIONSTATUS";

      public static final String ORGANIZATIONTYPE = "ORGANIZATIONTYPE";

      public static final String PARENTID = "PARENTID";

      public static final String BIGID = "BIGID";

  }

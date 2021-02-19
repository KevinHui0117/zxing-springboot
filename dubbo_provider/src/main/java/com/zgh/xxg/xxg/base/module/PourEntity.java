package com.zgh.xxg.xxg.base.module;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 业务基础实体
 *
 * @author xpc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PourEntity implements Serializable {

    public PourEntity(Operater operater) {
        this.operater = operater;
    }

    /**
     * 乐观锁
     */
    @Version
    @JsonIgnore
    @TableField(value = "VERSION" , fill = FieldFill.INSERT, select = false)
    @ApiModelProperty(value = "乐观锁版本号", hidden = true)
    private Integer version;

    /**
     * 逻辑删除 。 0否，1是
     */
    @TableLogic
    /**
     * 忽略展现在接口文档与响应内容里
     */
    @JsonIgnore
    /**
     * select = false  排除查询中，出现逻辑删除字段
     * fill = FieldFill.INSERT  自动填充  详见PourMetaObjectHandler
     */
    @TableField(value = "DELETED", fill = FieldFill.INSERT , select = false)
    @ApiModelProperty(value = "逻辑删除字段", hidden = true)
    private Boolean deleted;


    /**
     * 创建者id
     */
    @TableField(value = "CREATER", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者id")
    private Long creater;

    /**
     * 创建者名称
     */
    @TableField(value = "CREATENAME", fill = FieldFill.INSERT,whereStrategy = FieldStrategy.NOT_EMPTY)
    @ApiModelProperty(value = "创建者名称")
    private String createname;

    /**
     * 创建者时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "CREATETIME", fill = FieldFill.INSERT,condition = SqlConditionPlus.LIKE,whereStrategy = FieldStrategy.NOT_EMPTY)
    @ApiModelProperty(value = "创建者时间")
    private String createtime;

    /**
     * 修改者id
     */
    @TableField(value = "UPDATER", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改者id")
    private Long updater;

    /**
     * 修改者名称
     */
    @TableField(value = "UPDATENAME", fill = FieldFill.INSERT_UPDATE,whereStrategy = FieldStrategy.NOT_EMPTY)
    @ApiModelProperty(value = "修改者名称")
    private String updatename;

    /**
     * 修改者时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "UPDATETIME", fill = FieldFill.INSERT_UPDATE,condition = SqlConditionPlus.LIKE,whereStrategy = FieldStrategy.NOT_EMPTY)
    @ApiModelProperty(value = "修改者时间")
    private String updatetime;

    /**
     * 数据权限代码
     */
    @TableField(value = "DATACODE")
    @ApiModelProperty(value = "数据权限代码")
    private String datacode;
    /**
     * 注释
     */
    @TableField(value = "NOTE")
    @ApiModelProperty(value = "注释")
    private String note;

    /**
     * session信息
     */
    @TableField(exist = false)
    private Operater operater;

    public static final String CREATER = "creater";

    public static final String CREATENAME = "createname";

    public static final String CREATETIME = "createtime";

    public static final String UPDATER = "updater";

    public static final String UPDATENAME = "updatename";

    public static final String UPDATETIME = "updatetime";

    public static final String DELETED = "deleted";

    public static final String VERSION = "version";

    public static final String NOTE = "note";

    public static final String DATACODE = "datacode";


}

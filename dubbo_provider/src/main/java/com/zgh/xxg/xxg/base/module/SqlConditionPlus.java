package com.zgh.xxg.xxg.base.module;

/**
 * SQL 比较条件常量定义类
 *
 * @author xupc
 * @since 2020-12-05
 */
public class SqlConditionPlus {
    /**
     * 等于
     */
    public static final String EQUAL = "%s=#{%s}";
    /**
     * 不等于
     */
    public static final String NOT_EQUAL = "%s&lt;&gt;#{%s}";
    /**
     * % 两边 %
     */
    public static final String LIKE = "%s LIKE CONCAT(CONCAT('%%',#{%s}),'%%')";
    /**
     * % 左
     */
    public static final String LIKE_LEFT = "%s LIKE CONCAT('%%',#{%s})";
    /**
     * 右 %
     */
    public static final String LIKE_RIGHT = "%s LIKE CONCAT(#{%s},'%%')";
}

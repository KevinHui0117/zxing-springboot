package com.zgh.xxg.xxg.app.annotation;

/**
 * @author caiyz
 * @since 2020-05-09 11:04
 **/
public interface IEnum {

    String EMPTY_VALUE = "";
    int EMPTY_VALUE_INT = 999;

    /**
     * 返回name属性
     * @return name
     */
    default String name() {
        return EMPTY_VALUE;
    }

    /**
     * 返回value属性
     * @return value
     */
    default int value() {
        return EMPTY_VALUE_INT;
    }

    /**
     * 返回text属性
     * @return text
     */
    default String text() {
        return EMPTY_VALUE;
    }
}

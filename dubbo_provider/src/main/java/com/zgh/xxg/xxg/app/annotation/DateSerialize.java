package com.zgh.xxg.xxg.app.annotation;


import java.lang.annotation.*;

/**
 * spring入参日期时间值转换 自定义扩展
 * @author caiyz
 * @since 2020-05-09 11:04
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface DateSerialize {

    /**
     * BEGIN: 转换date开始时间 2020-08-21 00：00：00
     * END  : 转换date结束时间 2020-08-21 23：59：59
     */
    TYPE type();

    /**
     * 时间类型
     */
    ISO iso() default ISO.DATE;

    /**
     * 提交Date日期格式
     */
    String pattern() default "yyyy-MM-dd";


    enum TYPE {
        BEGIN,
        END
    }

    enum ISO {

        DATE,
        TIME,
        DATE_TIME,

        TIME_STR,
        NONE
    }
}

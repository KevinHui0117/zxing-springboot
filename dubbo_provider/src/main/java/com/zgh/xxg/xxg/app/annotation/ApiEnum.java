package com.zgh.xxg.xxg.app.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * swagger文档枚举类型备注说明 自定义扩展
 * @author caiyz
 * @since 2020-08-25 13:23
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiEnum {

    /**
     * 枚举NAME属性
     */
    String name() default "name";

    /**
     * 枚举VALUE属性
     */
    String value() default "value";

    /**
     * 枚举TEXT属性
     */
    String text() default "text";

}
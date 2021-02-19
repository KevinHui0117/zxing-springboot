package com.zgh.xxg.xxg.app.utils;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author caiyz
 * @since 2020-04-17 15:21
 */
public class AppNumberUtils extends NumberUtils {

    public static Integer defaultInteger (Integer value) {
        return value == null ? INTEGER_ZERO: value;
    }

    public static Integer defaultIfEmpty(Integer value, Integer defaultVal) {
        return value == null ? defaultVal: value;
    }

}

/**
 * Copyright (c) 2005-2012 springside.org.cn
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.zgh.xxg.xxg.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author huikai
 * @ClassName: Exceptions
 * @Description: TODO(关于异常的工具类.)
 * @date 2019-07-18 11:10:56
 */
public class Exceptions {

    /**
     * 将CheckedException转换为UncheckedException.
     */
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }

    /**
     * 将CheckedException转换为UncheckedException.
     */
    public static RuntimeException unchecked(String message, Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(message, e);
        }
    }

    /**
     * 产生UncheckedException实例
     */
    public static RuntimeException unchecked(String message) {
        return new RuntimeException(message);
    }

    /**
     * 将ErrorStack转化为String.
     */
    public static String getStackTraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}

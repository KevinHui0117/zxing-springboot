package com.zgh.xxg.xxg.app.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * app考勤模块 String工具类
 *
 * @author huikai
 * @since 2020-04-07 10:36:36
 */
public class AppStringUtils extends StringUtils {
    public static String isNullStr(Object obj) {
        String str = "";
        if (obj == null || obj.equals("null")) {
            str = "";
        } else {
            str = String.valueOf(obj);
        }
        return str;
    }

    public static boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static String isNullToZero(Object obj) {
        String str = "";
        if (obj == null || obj.equals("null") || obj.equals("")) {
            str = "0";
        } else {
            str = String.valueOf(obj);
        }
        return str.trim();
    }

    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 判断是否不为null或非空字符
     */
    public static boolean isNotNullOrEmpty(Object o) {
        return !isNullOrEmpty(o);
    }

    /**
     * 判断是否为null或空字符
     */
    public static boolean isNullOrEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (String.valueOf(o).replace((char) 12288, ' ').trim().length() == 0) {
            return true;
        }
        if ("null".equals(o)) {
            return true;
        }
        return false;
    }

    /**
     * 去除字符串中最后一个自定义字符
     */
    public static String removeLast(String code, String param) {
        if (param.equals(String.valueOf(code.charAt(code.length() - 1)))) {
            int start = code.length() - 1;
            int end = code.length();
            code = code.substring(start, end);
        }
        return code;
    }

    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isEmpty(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 返回字符串最大值
     */
    public static String max(final String... element) {
        String s = defaultString(element[0]);
        for (int i = 1; i < element.length; i++) {
            s = isEmpty(element[i]) || s.compareTo(element[i]) > 0 ? s : element[i];
        }
        return s;
    }

    /**
     * 返回字符串最小值
     */
    public static String min(final String... element) {
        String s = defaultString(element[0]);
        for (int i = 1; i < element.length; i++) {
            s = isNotEmpty(element[i]) && s.compareTo(element[i]) < 0 ? element[i] : s;
        }
        return s;
    }

    /**
     * 获取字符s在字符串url中第i次出现的下标（从0开始）
     * @param url,s,i
     * @return int
     * @author shuws
     */
    public static int getCharacterPosition(String url, String s, int i) {
        //这里是获取"/"符号的位置	lastindexof从字符串末尾开始检索，检索到子字符
        Matcher slashMatcher = Pattern.compile(s).matcher(url);
        int mIdx = 0;
        while (slashMatcher.find()) {
            mIdx++;
            //当"/"符号第i次出现的位置
            if (mIdx == i) {
                break;
            }
        }
        return slashMatcher.start();
    }
}

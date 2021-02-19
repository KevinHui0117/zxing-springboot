package com.zgh.xxg.CodeEnums;

/**
 * 下载二维码格式参数
 * @author huikai
 * @since 2021-01-12
 */
public enum CodeTypeEnum {

    DYNAMIC(1, "动态码"),
    STATIC(2, "静态码");

    private final int value;
    private final String text;

    CodeTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int value() {
        return value;
    }

    public String text() {
        return text;
    }

    public static CodeTypeEnum fromValue(int typeCode) {
        for (CodeTypeEnum o : CodeTypeEnum.values()) {
            if (o.value == typeCode) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }

    public static CodeTypeEnum fromText(String typeCode) {
        for (CodeTypeEnum o : CodeTypeEnum.values()) {
            if (o.text.equals(typeCode)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }
}
package com.zgh.xxg.CodeEnums;

/**
 * 下载二维码格式参数
 * @author huikai
 * @since 2021-01-12
 */
public enum CodeClassificationEnum {

    COMMON(1, "普通二维码"),
    CHANNEL(2, "渠道二维码"),
    SYSTEM(3, "系统二维码");

    private final int value;
    private final String text;

    CodeClassificationEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int value() {
        return value;
    }

    public String text() {
        return text;
    }

    public static CodeClassificationEnum fromValue(int typeCode) {
        for (CodeClassificationEnum o : CodeClassificationEnum.values()) {
            if (o.value == typeCode) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }

    public static CodeClassificationEnum fromText(String typeCode) {
        for (CodeClassificationEnum o : CodeClassificationEnum.values()) {
            if (o.text.equals(typeCode)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }
}
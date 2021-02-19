package com.zgh.xxg.CodeEnums;

/**
 * 下载二维码格式参数
 * @author huikai
 * @since 2021-01-12
 */
public enum FrequencyEnum {

    SECOND(1, "秒"),
    MINUTE(2, "分钟"),
    HOUR(3, "小时"),
    DAY(4, "天");

    private final int value;
    private final String text;

    FrequencyEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int value() {
        return value;
    }

    public String text() {
        return text;
    }

    public static FrequencyEnum fromValue(int typeCode) {
        for (FrequencyEnum o : FrequencyEnum.values()) {
            if (o.value == typeCode) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }

    public static FrequencyEnum fromText(String typeCode) {
        for (FrequencyEnum o : FrequencyEnum.values()) {
            if (o.text.equals(typeCode)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }
}
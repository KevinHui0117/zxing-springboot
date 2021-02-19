package com.zgh.xxg.xxg.app.constants;


import com.zgh.xxg.xxg.app.annotation.IEnum;

/**
 * @author caiyz
 * @since 2020-04-07 09:45:48
 */
public enum YNTag implements IEnum {
    /** 是 */
    Y(1, "是"),
    /** 否 */
    N(0, "否");

    private final int value;
    private final String text;

    YNTag(int value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public int value() {
        return value;
    }

    @Override
    public String text() {
        return text;
    }

    public static YNTag fromValue(int typeCode) {
        for (YNTag o : YNTag.values()) {
            if (o.value == typeCode) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }

    public static YNTag fromText(String typeCode) {
        for (YNTag o : YNTag.values()) {
            if (o.text.equals(typeCode)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }
}
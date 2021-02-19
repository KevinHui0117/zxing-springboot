package com.zgh.xxg.xxg.app.constants;


import com.zgh.xxg.xxg.app.annotation.IEnum;

/**
 * @author huikai
 * @since 2020-10-16 09:45:48
 */
public enum SaveOrUpdateTag implements IEnum {
    /** 是 */
    Commit(1, "提交"),
    /** 否 */
    Save(0, "暂存");

    private final int value;
    private final String text;

    SaveOrUpdateTag(int value, String text) {
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

    public static SaveOrUpdateTag fromValue(int typeCode) {
        for (SaveOrUpdateTag o : SaveOrUpdateTag.values()) {
            if (o.value == typeCode) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }

    public static SaveOrUpdateTag fromText(String typeCode) {
        for (SaveOrUpdateTag o : SaveOrUpdateTag.values()) {
            if (o.text.equals(typeCode)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }
}
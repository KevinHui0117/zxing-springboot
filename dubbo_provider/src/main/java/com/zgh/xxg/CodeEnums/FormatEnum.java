package com.zgh.xxg.CodeEnums;

/**
 * 下载二维码格式参数
 * @author huikai
 * @since 2021-01-12
 */
public enum FormatEnum {

    PNG_LARGE(1, "PNG大尺寸.png"),
    PNG_MID(2, "PNG中等尺寸.png"),
    PNG_SMALL(3, "PNG小尺寸.png"),
    VECTOR_PDF(4, "PDF格式.pdf"),
    VECTOR_SVG(5, "SVG格式.svg"),
    VECTOR_EPS(6, "EPS格式.eps");

    private final int value;
    private final String text;

    FormatEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int value() {
        return value;
    }

    public String text() {
        return text;
    }

    public static FormatEnum fromValue(int typeCode) {
        for (FormatEnum o : FormatEnum.values()) {
            if (o.value == typeCode) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }

    public static FormatEnum fromText(String typeCode) {
        for (FormatEnum o : FormatEnum.values()) {
            if (o.text.equals(typeCode)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Illegal argument type value: " + typeCode);
    }
}
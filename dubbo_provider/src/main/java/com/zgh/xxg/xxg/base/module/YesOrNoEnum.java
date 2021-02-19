package com.zgh.xxg.xxg.base.module;


import lombok.Getter;

@Getter
public enum YesOrNoEnum implements IBaseEnum<String> {
  NO("0", "否"),
  YES("1", "是");

  private final String code;
  private final String msg;

  YesOrNoEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public String getValue() {
    return code;
  }

  public static String getMsg(String code) {
    for (YesOrNoEnum allEnum : values()) {
      if (allEnum.code.equals(code)) {
        return allEnum.msg;
      }
    }
    return null;
  }

}

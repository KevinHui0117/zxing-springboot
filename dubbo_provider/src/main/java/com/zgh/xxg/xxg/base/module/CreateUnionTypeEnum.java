package com.zgh.xxg.xxg.base.module;


import lombok.Getter;

@Getter
public enum CreateUnionTypeEnum implements IBaseEnum<String> {

  OFFLINE("1", "线下建会"),
  ONLINE("2", "网上建会");

  private final String code;
  private final String msg;

  CreateUnionTypeEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public String getValue() {
    return code;
  }
  public static String getMsg(String code) {
    for (CreateUnionTypeEnum allEnum : values()) {
      if (allEnum.code.equals(code)) {
        return allEnum.msg;
      }
    }
    return null;
  }
}

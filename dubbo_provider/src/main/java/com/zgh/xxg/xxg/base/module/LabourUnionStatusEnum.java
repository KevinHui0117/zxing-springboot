package com.zgh.xxg.xxg.base.module;


import lombok.Getter;

@Getter
public enum LabourUnionStatusEnum implements IBaseEnum<String> {
  DELETE("0", "删除"),
  NORMAL("1", "正常"),
  LOCK("3", "锁住"),
  PREPARE("4", "筹备期"),
  LOGOUT("5", "注销");

  private final String code;
  private final String msg;

  LabourUnionStatusEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public String getValue() {
    return code;
  }
  public static String getMsg(String code) {
    for (LabourUnionStatusEnum allEnum : values()) {
      if (allEnum.code.equals(code)) {
        return allEnum.msg;
      }
    }
    return null;
  }
}

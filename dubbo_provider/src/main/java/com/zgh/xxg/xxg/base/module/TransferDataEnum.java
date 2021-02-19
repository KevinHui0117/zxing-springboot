package com.zgh.xxg.xxg.base.module;


import lombok.Getter;

@Getter
public enum TransferDataEnum implements IBaseEnum<String> {
  CLGHPF("1", "成立工会批复"),
  HJXJJGPF("2", "换届选举结果批复"),
  ZFZXCBB("3", "正副主席呈报表"),
  GHSWWY("4", "工会三委委员、劳动法律监督委员名册"),
  YHHMC("5", "会员花名册"),
  QT("6", "其他");


  private final String code;
  private final String msg;

  TransferDataEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public String getValue() {
    return code;
  }
  public static String getMsg(String code) {
    for (TransferDataEnum allEnum : values()) {
      if (allEnum.code.equals(code)) {
        return allEnum.msg;
      }
    }
    return null;
  }
}

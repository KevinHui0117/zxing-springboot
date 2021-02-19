package com.zgh.xxg.xxg.app.model;

/**
 * 国际化工具类
 * @author huikai
 * @since 2020-04-01 17:23:47
 */
public enum LocaleType {
    zh("zh","CN");


    private String name;
    private String country;

    LocaleType(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

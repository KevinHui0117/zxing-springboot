package com.zgh.xxg.xxg.app.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * @author xpc
 */
public class ApiInfoConfig {

    /**
     * 分组信息
     * @param title 标题
     * @param description 简介
     * @param version 版本号
     * @param username 接口开发人
     * @return
     */
    protected ApiInfo apiInfo(String title, String description, String version, String username) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl("http://www.xmzgh.org/")
                .version(version)
                .contact(new Contact(username,"http://www.xminfoport.com/WebHome.aspx","mail@xmigc.com"))
                .build();
    }
}

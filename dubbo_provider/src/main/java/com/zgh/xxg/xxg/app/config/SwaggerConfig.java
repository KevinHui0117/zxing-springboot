package com.zgh.xxg.xxg.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xpc
 */
@Configuration
@EnableSwagger2
//@EnableSwaggerBootstrapUI
@ComponentScan(basePackages={"com.zgh"})
public class SwaggerConfig extends ApiInfoConfig {

    @Bean
    public Docket createRestApi() {
        return new DocketPlugin()
                .groupName("系统参数")
                .apiInfo(apiInfo("系统参数", "业务平台的系统参数接口，采用application/json","1.0","xpc"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.basiclevelunion.service.impl"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket tyspApi() {
        return new DocketPlugin()
                .groupName("通用申报")
                .apiInfo(apiInfo("通用申报", "通用申报App端接口","1.0","csz"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.tysp.controller"))
                .paths(PathSelectors.ant("/app/tysp/*"))
                .build();
    }

    @Bean
    public Docket tyspFrontApi() {
        return new DocketPlugin()
                .groupName("通用申报群众办事")
                .apiInfo(apiInfo("通用申报群众办事", "通用申报群众办事App端接口","1.0","csz"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.tysp.controller"))
                .paths(PathSelectors.ant("/app/tyspFront/*"))
                .build();
    }

    @Bean
    public Docket dxglApi() {
        return new DocketPlugin()
                .groupName("对象管理")
                .apiInfo(apiInfo("对象管理", "对象管理App端接口","1.0","csz"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.dxgl.controller"))
                .paths(PathSelectors.ant("/app/dxgl/*"))
                .build();
    }

    @Bean
    public Docket usercenterApi() {
        return new DocketPlugin()
                .groupName("用户中心")
                .apiInfo(apiInfo("用户中心", "用户中心App端接口","1.0","csz"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.usercenter.controller"))
                .paths(PathSelectors.ant("/app/usercenter/*"))
                .build();
    }
    @Bean
    public Docket memberApi() {
        return new DocketPlugin()
                .groupName("会员公用")
                .apiInfo(apiInfo("会员公用", "会员公用App端接口","1.0","wyl"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.ghhy.controller"))
                .paths(PathSelectors.ant("/app/memberCommon/*"))
                .build();
    }
    @Bean
    public Docket applyJoinApi() {
        return new DocketPlugin()
                .groupName("入会申请")
                .apiInfo(apiInfo("入会申请", "会员入会申请App端接口","1.0","wyl"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.ghhy.controller"))
                .paths(PathSelectors.ant("/app/applyJoin/*"))
                .build();
    }

    @Bean
    public Docket changeApi() {
        return new DocketPlugin()
                .groupName("会籍变更")
                .apiInfo(apiInfo("会籍变更", "会籍变更App端接口","1.0","wyl"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.ghhy.controller"))
                .paths(PathSelectors.ant("/app/memberChange/*"))
                .build();
    }
    @Bean
    public Docket cardApi() {
        return new DocketPlugin()
                .groupName("会员卡")
                .apiInfo(apiInfo("会员卡", "会员卡App端接口","1.0","wyl"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.ghhy.controller"))
                .paths(PathSelectors.ant("/app/card/*"))
                .build();
    }

    @Bean
    public Docket createSignatureApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("签名服务")
                .apiInfo(apiInfo("签名服务", "签名服务RESTful APIs", "1.0", "csz"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.business.signature.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createLearnForDreamApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("求学圆梦服务")
                .apiInfo(apiInfo("求学圆梦服务", "求学圆梦服务 RESTful APIs", "1.0", ""))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.business.learnForDream.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createQrCodeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("二维码管理服务")
                .apiInfo(apiInfo("二维码管理服务", "二维码管理服务 RESTful APIs", "1.0", ""))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zgh.app.business.qrCode.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createF2RestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("F2 REST接口")
                .apiInfo(apiInfo("F2 REST接口", "F2模块RESTful APIs", "1.0", "f2"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.f2bpm.controller.webapi"))
                .paths(PathSelectors.any())
                .build();
    }

}

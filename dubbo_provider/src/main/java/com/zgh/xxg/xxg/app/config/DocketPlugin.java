package com.zgh.xxg.xxg.app.config;

import com.zgh.xxg.xxg.app.model.ResultStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : xpc
 */
public class DocketPlugin extends Docket {

    public DocketPlugin(DocumentationType documentationType) {
        super(documentationType);
    }

    private void statusCode(List<ResponseMessage> responseMessageList) {
        //可自行添加全局状态码与说明
        responseMessageList.add(new ResponseMessageBuilder().code(ResultStatus.FAIL.getCode()).message(ResultStatus.FAIL.getMessage()).build());
        responseMessageList.add(new ResponseMessageBuilder().code(ResultStatus.SUCCESS.getCode()).message(ResultStatus.SUCCESS.getMessage()).build());
    }

    public DocketPlugin() {
        super(DocumentationType.SWAGGER_2);
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        statusCode(responseMessageList);
        //遍历请求方式，把状态码加入到所有请求方式中
        Arrays.asList(RequestMethod.values()).stream()
                .forEach(m -> globalResponseMessage(m, responseMessageList));
    }


}

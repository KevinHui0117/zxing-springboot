package com.zgh;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WarConfig
 * @Description: 部署war包
 * @Author MACHENIKE
 * @Date 2021/2/18
 * @Version V1.0
 **/
@Configuration
public class WarConfig extends SpringBootServletInitializer {

    //注意,这里的DemoApplication是启动类
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DubboProviderApplication.class);
    }

}

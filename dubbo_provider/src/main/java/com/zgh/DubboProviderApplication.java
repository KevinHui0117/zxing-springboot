package com.zgh;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName 第一个 Handler1，存储到数据库中
 * @Description: TODO
 * @Author MACHENIKE
 * @Date 2021/01/27
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDubbo
@EnableAsync//异步并发处理
@MapperScan("com.zgh.business.mapper")
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }

}

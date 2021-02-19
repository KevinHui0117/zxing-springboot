package com.zgh.business.entity;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Trade
 * @Description: TODO
 * @Author MACHENIKE
 * @Date 2021/2/2
 * @Version V1.0
 **/
@Data
public class Trade {

    private String id;//ID
    private String name;
    private double price;//金额
    private AtomicInteger count = new AtomicInteger(0);

    // 省略getter/setter
}
package com.zgh.business.handlers;

import com.lmax.disruptor.EventHandler;
import com.zgh.business.entity.Trade;

/**
 * @ClassName 第二个 Handler2，订单信息发送到其它系统中
 * @Description: TODO
 * @Author MACHENIKE
 * @Date 2021/2/2
 * @Version V1.0
 **/


public class Handler2 implements EventHandler<Trade> {

    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        long threadId = Thread.currentThread().getId();     // 获取当前线程id
        String id = event.getId();                          // 获取订单号
        System.out.println(String.format("%s：Thread Id %s 订单信息 %s 发送到 karaf 系统中 ....",
                this.getClass().getSimpleName(), threadId, id));
    }
}

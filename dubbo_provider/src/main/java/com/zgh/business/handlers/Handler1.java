package com.zgh.business.handlers;


import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.zgh.business.entity.Trade;

/**
 * @ClassName 第一个 Handler1，存储到数据库中
 * @Description: TODO
 * @Author MACHENIKE
 * @Date 2021/2/2
 * @Version V1.0
 **/
public class Handler1 implements EventHandler<Trade>, WorkHandler<Trade> {

    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }

    @Override
    public void onEvent(Trade event) throws Exception {
        long threadId = Thread.currentThread().getId();     // 获取当前线程id
        String id = event.getId();                          // 获取订单号
        System.out.println(String.format("%s：Thread Id %s 订单信息保存 %s 到数据库中 ....",
                this.getClass().getSimpleName(), threadId, id));
    }
}

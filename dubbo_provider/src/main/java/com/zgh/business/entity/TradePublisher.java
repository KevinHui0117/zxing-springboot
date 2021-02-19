package com.zgh.business.entity;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TradePublisher
 * @Description: TODO
 * @Author MACHENIKE
 * @Date 2021/2/2
 * @Version V1.0
 **/
public class TradePublisher implements Runnable {

    private static int LOOP = 1;    // 模拟百万次交易的发生
    Disruptor<Trade> disruptor;
    private CountDownLatch latch;

    public TradePublisher(CountDownLatch latch, Disruptor<Trade> disruptor) {
        this.disruptor = disruptor;
        this.latch = latch;
    }

    @Override
    public void run() {
        TradeEventTranslator tradeTransloator = new TradeEventTranslator();
        for (int i = 0; i < LOOP; i++) {
            disruptor.publishEvent(tradeTransloator);
        }
        latch.countDown();
    }

}

class TradeEventTranslator implements EventTranslator<Trade> {

    @Override
    public void translateTo(Trade event, long sequence) {
        event.setId(UUID.randomUUID().toString());
    }

}
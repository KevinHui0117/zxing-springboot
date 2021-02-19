//package com.zgh.hjljy.dubbo_provider;
//
//import com.lmax.disruptor.EventFactory;
//import com.lmax.disruptor.YieldingWaitStrategy;
//import com.lmax.disruptor.dsl.EventHandlerGroup;
//import com.zgh.business.entity.Trade;
//import com.zgh.business.entity.TradePublisher;
//import com.zgh.business.handlers.Handler1;
//import com.zgh.business.handlers.Handler2;
//import com.zgh.business.handlers.Handler3;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import com.lmax.disruptor.BusySpinWaitStrategy;
//import com.lmax.disruptor.dsl.Disruptor;
//import com.lmax.disruptor.dsl.ProducerType;
//
//@SpringBootTest
//class DubboProviderApplicationTests {
//
//    @Test
//    void test() {
//        long beginTime = System.currentTimeMillis();
//        int bufferSize = 1024;
//        ExecutorService executor = Executors.newFixedThreadPool(8);
//
//        Disruptor<Trade> disruptor = new Disruptor<>(new EventFactory<Trade>() {
//            @Override
//            public Trade newInstance() {
//                return new Trade();
//            }
//        }, bufferSize, executor, ProducerType.SINGLE, new YieldingWaitStrategy());
//
//        // 使用disruptor创建消费者组C1, C2
//        EventHandlerGroup<Trade> handlerGroup = disruptor.handleEventsWith(new Handler1(), new Handler2());
//        // 声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
//        // 多个消费者不重复消费
//        Handler3[] customers = new Handler3[]{new Handler3(), new Handler3(), new Handler3()};
//        handlerGroup.thenHandleEventsWithWorkerPool(customers);
//
//        disruptor.start();//启动
//        CountDownLatch latch = new CountDownLatch(1);
//        //生产者准备
//        executor.submit(new TradePublisher(latch, disruptor));
//
//        try {
//            latch.await();//等待生产者完事.
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        disruptor.shutdown();
//        executor.shutdown();
//        System.out.println("总耗时:" + (System.currentTimeMillis() - beginTime));
//    }
//
//}

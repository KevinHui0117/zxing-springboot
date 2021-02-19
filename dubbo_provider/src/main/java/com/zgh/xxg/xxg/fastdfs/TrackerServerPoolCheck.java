package com.zgh.xxg.xxg.fastdfs;

import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @ClassName: HeartBeat
 * @Description: 定时检查连接池，删除无效的连接
 * @date 2020年02月21日
 * 
 */
public class TrackerServerPoolCheck {
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerServerPoolCheck.class);
	/** fastdfs连接池 */
	private TrackerServerPool pool = null;
	/** 小时毫秒数 */
	public static int ahour = 1000 * 60 * 60 * 1;
	/** 等待时间 */
	public static int waitTimes = 200;
 
	public TrackerServerPoolCheck(TrackerServerPool pool) {
		this.pool = pool;
	}
 
	/**
	 * 
	 * @Description: 定时执行任务，检测当前的空闲连接是否可用，如果不可用将从连接池中移除
	 * 
	 */
	public void check() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				LOGGER.info("对idleConnectionPool中的TrackerServer进行监测");
				LinkedBlockingQueue<TrackerServer> idleConnectionPool = pool.getIdleConnectionPool();
				TrackerServer ts = null;
				for (int i = 0; i < idleConnectionPool.size(); i++) {
					try {
						ts = idleConnectionPool.poll(waitTimes,TimeUnit.SECONDS);
						if (ts != null) {
							ProtoCommon.activeTest(ts.getSocket());
							idleConnectionPool.add(ts);
						} else {
							/** 代表已经没有空闲长连接 */
							break;
						}
					} catch (Exception e) {
						/** 发生异常,要删除，进行重建 */
						pool.drop(ts);
					}
				}
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, ahour, ahour);
	}
 
}
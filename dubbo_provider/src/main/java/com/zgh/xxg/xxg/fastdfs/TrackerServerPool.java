package com.zgh.xxg.xxg.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @ClassName: TrackerServerPool
 * @Description: fastdfs连接池
 * @date 2020年02月21日
 * 
 */
public class TrackerServerPool {
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerServerPool.class);
	
	/** 空闲的连接池 */
	private LinkedBlockingQueue<TrackerServer> idleConnectionPool = null;
	/** 连接池默认最小连接数 */
	private long minPoolSize = 5;
	/** 连接池默认最大连接数 */
	private long maxPoolSize = 10;
	/** 当前创建的连接数 */
	private volatile long nowPoolSize = 0;
	/** 默认等待时间（单位：秒） */
	private long waitTimes = 200;

 
	public TrackerServerPool(long minPoolSize, long maxPoolSize, long waitTimes) {
		this.minPoolSize = minPoolSize;
		this.maxPoolSize = maxPoolSize;
		this.waitTimes = waitTimes;
		/** 初始化连接池 */
		poolInit();
		/** 注册连接检查，删除无效连接 */
		TrackerServerPoolCheck trackerServerPoolCheck = new TrackerServerPoolCheck(this);
		trackerServerPoolCheck.check();
	}
 
	/**
	 * 
	 * @Description: 连接池初始化 (在加载当前ConnectionPool时执行) 1).加载配置文件 2).空闲连接池初始化；
	 *               3).创建最小连接数的连接，并放入到空闲连接池；
	 * 
	 */
	private void poolInit() {
		LOGGER.info("fastDFS初始化空闲连接池,参数：minPoolSize=" + minPoolSize + ",maxPoolSize="
				+ maxPoolSize + ",waitTimes=" + waitTimes);
		try {
			/** 加载配置文件 */
			initClientGlobal();
			/** 初始化空闲连接池 */
			idleConnectionPool = new LinkedBlockingQueue<TrackerServer>();
			/** 往线程池中添加默认大小的线程 */
			for (int i = 0; i < minPoolSize; i++) {
				createTrackerServer();
			}
		} catch (Exception ex) {
			LOGGER.error("fastDFS初始化空闲连接池异常："+ex.getMessage(), ex);
		}
	}
 
	/**
	 * 
	 * @Description: 创建TrackerServer,并放入空闲连接池
	 * 
	 */
	public void createTrackerServer() {
 
		LOGGER.info("创建TrackerServer");
		TrackerServer trackerServer = null;
 
		try {
			TrackerClient trackerClient = new TrackerClient();
			trackerServer = trackerClient.getConnection();
			int i=1;
			while (trackerServer == null && i < 5) {
				LOGGER.info("创建TrackerServer,第" + i + "次创建");
				i++;
				initClientGlobal();
				trackerServer = trackerClient.getConnection();
			}
			if(trackerServer!=null && ProtoCommon.activeTest(trackerServer.getSocket())){
				idleConnectionPool.add(trackerServer);
				/** 同一时间只允许一个线程对nowPoolSize操作 **/
				synchronized (this) {
					nowPoolSize++;
				}
			}
		} catch (Exception ex) {
			LOGGER.error("创建TrackerServer异常："+ex.getMessage(), ex);
		} finally {
			if (trackerServer != null) {
				try {
					trackerServer.close();
				} catch (Exception ex) {
					LOGGER.error("创建TrackerServer--关闭trackerServer异常："+ex.getMessage(), ex);
				}
			}
		}
	}
 
	/**
	 * 
	 * @Description: 获取空闲连接 1).在空闲池（idleConnectionPool)中弹出一个连接；
	 *               2).把该连接放入忙碌池（busyConnectionPool）中; 3).返回 TrackerServer
	 *               4).如果没有idle connection, 等待 wait_time秒, and check again
	 * 
	 * 
	 */
	public TrackerServer checkout() throws Exception {
		LOGGER.info("获取空闲TrackerServer");
		TrackerServer trackerServer = idleConnectionPool.poll();
		if (trackerServer == null) {
			if (nowPoolSize < maxPoolSize) {
				createTrackerServer();
				try {
					trackerServer = idleConnectionPool.poll(waitTimes,TimeUnit.SECONDS);
				} catch (Exception ex) {
					LOGGER.error("获取空闲连接TrackerServer连接超时",ex);
					throw ex;
				}
			}
			if (trackerServer == null) {
				throw new Exception("获取空闲连接TrackerServer连接超时");
			}
		}
		LOGGER.info("获取空闲连接TrackerServer成功");
		return trackerServer;
 
	}
 
	/**
	 * 
	 * @Description: 释放繁忙连接 1.如果空闲池的连接小于最小连接值，就把当前连接放入idleConnectionPool；
	 *               2.如果空闲池的连接等于或大于最小连接值，就把当前释放连接丢弃；
	 * 
	 * @param client1
	 *            需释放的连接对象
	 * 
	 */
 
	public void checkin(TrackerServer trackerServer) {
		LOGGER.info("释放当前连接TrackerServer,params:" + trackerServer);
		if (trackerServer != null) {
			if (idleConnectionPool.size() < minPoolSize) {
				idleConnectionPool.add(trackerServer);
			} else {
				synchronized (this) {
					if (nowPoolSize != 0) {
						nowPoolSize--;
					}
				}
			}
		}
	}
	
 
	/**
	 * 
	 * @Description: 删除不可用的连接，并把当前连接数减一（调用过程中trackerServer报异常，调用一般在finally中）
	 * @param trackerServer
	 * 
	 */
	public void drop(TrackerServer trackerServer) {
		LOGGER.info("删除不可用连接，parms:" + trackerServer	);
		if (trackerServer != null) {
			try {
				trackerServer.close();
				trackerServer=null;
				synchronized (this) {
					if (nowPoolSize != 0) {
						nowPoolSize--;
					}
				}
			} catch (IOException ex) {
				LOGGER.info("删除不可用连接，关闭trackerServer异常："+ex.getMessage(), ex);
			}
		}
	}
 
	private void initClientGlobal() throws Exception {
		 String classPath = new File(TrackerServerPool.class.getResource("/").getFile()).getCanonicalPath();
         String fdfsClientConfigFilePath = classPath + File.separator + "fdfs_client.properties";
		ClientGlobal.init(fdfsClientConfigFilePath);
	}
 
	public LinkedBlockingQueue<TrackerServer> getIdleConnectionPool() {
		return idleConnectionPool;
	}
 
	public long getMinPoolSize() {
		return minPoolSize;
	}
 
	public void setMinPoolSize(long minPoolSize) {
		if (minPoolSize != 0) {
			this.minPoolSize = minPoolSize;
		}
	}
 
	public long getMaxPoolSize() {
		return maxPoolSize;
	}
 
	public void setMaxPoolSize(long maxPoolSize) {
		if (maxPoolSize != 0) {
			this.maxPoolSize = maxPoolSize;
		}
	}
 
	public long getWaitTimes() {
		return waitTimes;
	}
 
	public void setWaitTimes(int waitTimes) {
		if (waitTimes != 0) {
			this.waitTimes = waitTimes;
		}
	}
 
}
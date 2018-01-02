package com.rfc.util.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池监控器
 */
public class ThreadPoolMonitor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolMonitor.class);

    private ThreadPoolExecutor executor;

    public ThreadPoolMonitor(ThreadPoolExecutor executor) {
        this.executor = executor;
    }


    public void run() {
        LOGGER.info("[线程池监控] PoolSize: {}, " +
                        "CorePoolSize: {}, " +
                        "ActiveCount: {}, " +
                        "QueueSize: {}, " +
                        "RemainingCapacity: {}, " +
                        "CompletedTaskCount: {}, " +
                        "TaskCount: {}, " +
                        "isShutdown: {}, " +
                        "isTerminated: {}",
                this.executor.getPoolSize(),
                this.executor.getCorePoolSize(),
                this.executor.getActiveCount(),
                this.executor.getQueue().size(),
                this.executor.getQueue().remainingCapacity(),
                this.executor.getCompletedTaskCount(),
                this.executor.getTaskCount(),
                this.executor.isShutdown(),
                this.executor.isTerminated()
        );
    }

}

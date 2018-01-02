package com.rfc.util.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝策略
 */
public class CustomCallerRunsPolicy implements RejectedExecutionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomCallerRunsPolicy.class);

    public CustomCallerRunsPolicy() {
    }

    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        LOGGER.info("[线程池过载] PoolSize: {}, " +
                        "CorePoolSize: {}, " +
                        "ActiveCount: {}, " +
                        "QueueSize: {}, " +
                        "RemainingCapacity: {}, " +
                        "CompletedTaskCount: {}, " +
                        "TaskCount: {}, " +
                        "isShutdown: {}, " +
                        "isTerminated: {}",
                executor.getPoolSize(),
                executor.getCorePoolSize(),
                executor.getActiveCount(),
                executor.getQueue().size(),
                executor.getQueue().remainingCapacity(),
                executor.getCompletedTaskCount(),
                executor.getTaskCount(),
                executor.isShutdown(),
                executor.isTerminated()
        );

        if (!executor.isShutdown()) {
            r.run();
        }
    }

}

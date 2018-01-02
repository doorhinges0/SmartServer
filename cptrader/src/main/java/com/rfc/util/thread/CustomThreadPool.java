package com.rfc.util.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.*;

/**
 * 基于JAVA原生线程池做定制化
 */
@Component
public class CustomThreadPool {

//    @Value("${core.pool.size}")
    private int corePoolSize = 25*2/10;

//    @Value("${max.pool.size}")
    private int maxPoolSize = 50*2/10;

//    @Value("${queue.capacity}")
    private int queueCapacity = 5000;

//    @Value("${keepAliveSeconds}")
    private int keepAliveSeconds = 60;

//    @Value("${open_monitor}")
    private Boolean openMonitor = true;

//    @Value("${fixed_delay}")
    private int fixedDelay = 3;

    /**
     * 线程池实例
     */
    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * 线程池监控
     */
    private ScheduledExecutorService monitorScheduler;

    @PostConstruct
    public void initThreadPool() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(queueCapacity);
        threadPoolExecutor =
                new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveSeconds, TimeUnit.SECONDS,
                        workQueue, new CustomCallerRunsPolicy());
        //预热, 启动corePoolSize数目线程
        threadPoolExecutor.prestartCoreThread();
        //启动线程池监控线程
        startThreadPoolMonitor();
    }

    @PreDestroy
    public void destroy() {
        //关闭监控
        if (monitorScheduler != null) {
            monitorScheduler.shutdown();
        }

        //关闭线程池
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    /**
     * 启动线程池监控
     */
    private void startThreadPoolMonitor() {
        if(openMonitor) {
            monitorScheduler = Executors.newSingleThreadScheduledExecutor();
            monitorScheduler
                    .scheduleWithFixedDelay(new ThreadPoolMonitor(threadPoolExecutor), 1, fixedDelay, TimeUnit.SECONDS);
        }
    }

    public ExecutorService getExecutorService() {
        return threadPoolExecutor;
    }

}

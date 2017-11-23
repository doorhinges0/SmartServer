package com.fuck.mobile.spring.dubbo;

import ch.qos.logback.classic.LoggerContext;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.support.AbstractRegistry;
import com.alibaba.dubbo.registry.support.AbstractRegistryFactory;
import com.alibaba.dubbo.registry.support.FailbackRegistry;
import com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeClient;
import com.alibaba.dubbo.remoting.transport.AbstractClient;
import com.alibaba.dubbo.remoting.transport.dispatcher.WrappedChannelHandler;
import com.alibaba.dubbo.remoting.transport.netty.NettyClient;
import com.fuck.mobile.base.utils.ReflectUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientBossPool;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.util.HashedWheelTimer;
import org.slf4j.ILoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by MegaX on 2016/10/17.
 */
public final class DubboCleanup {
    private static Log log = LogFactory.getLog(DubboCleanup.class);
    private ApplicationContext app;
    private ArrayList<Registry> registries;

    private DubboCleanup()
    {

    }



    public static void endCleanUp(DubboCleanup config)
    {
        AbstractRegistryFactory.destroyAll();
        ProtocolConfig.destroyAll();


        for (Registry registry : config.registries)
        {
            if(registry instanceof FailbackRegistry)
            {
                try {
                    ScheduledExecutorService retryExecutor = (ScheduledExecutorService) ReflectUtil.getField(registry,"retryExecutor");
                    if(retryExecutor != null)
                    {
                        log.info("retryExecutor shutdown");
                        retryExecutor.shutdown();
                    }
                } catch (IllegalAccessException e) {
                    log.error("",e);
                }
            }
            if(registry instanceof AbstractRegistry)
            {
                try {
                    ExecutorService registryCacheExecutor = (ExecutorService)ReflectUtil.getField(registry,"registryCacheExecutor");
                    if(registryCacheExecutor != null)
                    {
                        log.info("registryCacheExecutor shutdown");
                        registryCacheExecutor.shutdown();
                    }
                } catch (IllegalAccessException e) {
                    log.error("",e);
                }
            }

        }
        try {
            ScheduledThreadPoolExecutor reconnectExecutorService = (ScheduledThreadPoolExecutor)ReflectUtil.getStaticField(AbstractClient.class,"reconnectExecutorService");
            if(reconnectExecutorService != null)
            {
                log.info("reconnectExecutorService shutdown");
                reconnectExecutorService.shutdown();
            }
        } catch (IllegalAccessException e) {
            log.error("",e);
        }

        try {
            ScheduledThreadPoolExecutor scheduled =(ScheduledThreadPoolExecutor) ReflectUtil.getStaticField(HeaderExchangeClient.class,"scheduled");
            if(scheduled != null)
            {
                log.info("scheduled shutdown");
                scheduled.shutdown();
            }
        } catch (IllegalAccessException e) {
            log.error("",e);
        }

        try {
            ExecutorService SHARED_EXECUTOR =(ExecutorService) ReflectUtil.getStaticField(WrappedChannelHandler.class,"SHARED_EXECUTOR");
            if(SHARED_EXECUTOR != null)
            {
                log.info("SHARED_EXECUTOR shutdown");
                SHARED_EXECUTOR.shutdown();
            }
        } catch (IllegalAccessException e) {
            log.error("",e);
        }

        try {
            ChannelFactory channelFactory =  (ChannelFactory)ReflectUtil.getStaticField(NettyClient.class,"channelFactory");
            if(channelFactory != null)
            {
                log.info("channelFactory shutdown");
                channelFactory.releaseExternalResources();
                channelFactory.shutdown();
            }
        } catch (IllegalAccessException e) {
            log.error("",e);
        }
        log.debug("dubbo cleanup finished ...............................");
        ILoggerFactory iLoggerFactory = org.slf4j.LoggerFactory.getILoggerFactory();
        if (iLoggerFactory instanceof LoggerContext) {
            LoggerContext context = (LoggerContext) iLoggerFactory;
            context.stop();
        }

    }

    public static DubboCleanup beginCleanUp(ApplicationContext app)
    {
        DubboCleanup dc = new DubboCleanup();
        dc.app = app;
        dc.registries = new ArrayList<>(AbstractRegistryFactory.getRegistries());

        log.error("registries-> " + dc.registries);
        return dc;


    }


}

package com.fuck.mobile.spring.dubbo.filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;
import com.fuck.mobile.spring.dubbo.AppExitProcess;
import com.fuck.mobile.spring.dubbo.exception.AppExitException;


@Activate(group={"consumer","provider"})
public class DubboFilter implements Filter {
	
	static Log log = LogFactory.getLog(DubboFilter.class);
	@Override
	public Result invoke(Invoker<?> paramInvoker, Invocation paramInvocation) throws RpcException {
//		System.out.println(paramInvoker.getClass());
		if(AppExitProcess.isExit())
		{
			String pro = paramInvoker.getUrl().getProtocol();
			if(StringUtils.equalsIgnoreCase("injvm", pro))
			{
				log.debug(paramInvoker.getUrl());
			}else
			{
				return new RpcResult(new AppExitException());
			}
		}
		log.debug(paramInvoker.getUrl());
		
		try
		{
			AppExitProcess.beforeInvoke();
			Result r = paramInvoker.invoke(paramInvocation);
			
			return r;
		}finally
		{
			AppExitProcess.afterInvoke();
		}
	}

}

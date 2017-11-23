package com.fuck.mobile.spring.dubbo.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.Version;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;
import com.alibaba.dubbo.rpc.cluster.support.AbstractClusterInvoker;
import com.fuck.mobile.spring.dubbo.exception.AppExitException;

public class FailoverXClusterInvoker<T> extends AbstractClusterInvoker<T> {
	private static Log logger = LogFactory.getLog(FailoverXClusterInvoker.class);

	public FailoverXClusterInvoker(Directory<T> directory) {
		super(directory);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Result doInvoke(Invocation invocation, final List<Invoker<T>> invokers, LoadBalance loadbalance)
			throws RpcException {
		List<Invoker<T>> copyinvokers = invokers;
		checkInvokers(copyinvokers, invocation);
		int len = getUrl().getMethodParameter(invocation.getMethodName(), Constants.RETRIES_KEY,
				Constants.DEFAULT_RETRIES) + 1;
		if (len <= 0) {
			len = 1;
		}
		// retry loop.
		RpcException le = null; // last exception.
		List<Invoker<T>> invoked = new ArrayList<Invoker<T>>(copyinvokers.size()); // invoked
																					// invokers.
		Set<String> providers = new HashSet<String>(len);
		
		//判断app正在退出
		boolean isAppExit = false;
		int AppExitTime = 0;
		
		for (int i = 0; i < len; i++) {
			do
			{
				isAppExit = false;
				// 重试时，进行重新选择，避免重试时invoker列表已发生变化.
				// 注意：如果列表发生了变化，那么invoked判断会失效，因为invoker示例已经改变
				if (i > 0) {
					checkWheatherDestoried();
					copyinvokers = list(invocation);
					// 重新检查一下
					checkInvokers(copyinvokers, invocation);
				}
				Invoker<T> invoker = select(loadbalance, invocation, copyinvokers, invoked);
				invoked.add(invoker);
				RpcContext.getContext().setInvokers((List) invoked);
				try {
					Result result = invoker.invoke(invocation);
					if (le != null && logger.isWarnEnabled()) {
						logger.warn("Although retry the method " + invocation.getMethodName() + " in the service "
								+ getInterface().getName() + " was successful by the provider "
								+ invoker.getUrl().getAddress() + ", but there have been failed providers " + providers
								+ " (" + providers.size() + "/" + copyinvokers.size() + ") from the registry "
								+ directory.getUrl().getAddress() + " on the consumer " + NetUtils.getLocalHost()
								+ " using the dubbo version " + Version.getVersion() + ". Last error is: "
								+ le.getMessage(), le);
					}
					if(result.hasException() && result.getException() instanceof AppExitException && 
							StringUtils.equals("consumer", invoker.getUrl().getParameter("side")))
					{
						isAppExit = true;
						AppExitTime++;
						logger.debug("Exiting ...... " + invoker.getUrl());
						System.out.println("Exiting ...... " + invoker.getUrl());
						continue;
					}
					return result;
				} catch (RpcException e) {
					if (e.isBiz()) { // biz exception.
						throw e;
					}
					le = e;
				} catch (Throwable e) {
					le = new RpcException(e.getMessage(), e);
				} finally {
					providers.add(invoker.getUrl().getAddress());
				}
			}while(isAppExit && AppExitTime < 3);
		}
		throw new RpcException(le != null ? le.getCode() : 0,
				"Failed to invoke the method " + invocation.getMethodName() + " in the service "
						+ getInterface().getName() + ". Tried " + len + " times of the providers " + providers + " ("
						+ providers.size() + "/" + copyinvokers.size() + ") from the registry "
						+ directory.getUrl().getAddress() + " on the consumer " + NetUtils.getLocalHost()
						+ " using the dubbo version " + Version.getVersion() + ". Last error is: "
						+ (le != null ? le.getMessage() : ""),
				le != null && le.getCause() != null ? le.getCause() : le);
	}

}

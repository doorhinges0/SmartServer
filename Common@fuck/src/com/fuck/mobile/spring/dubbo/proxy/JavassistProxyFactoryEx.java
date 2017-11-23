package com.fuck.mobile.spring.dubbo.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.bytecode.Proxy;
import com.alibaba.dubbo.common.bytecode.Wrapper;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.proxy.AbstractProxyFactory;
import com.alibaba.dubbo.rpc.proxy.AbstractProxyInvoker;
import com.alibaba.dubbo.rpc.proxy.InvokerInvocationHandler;

public class JavassistProxyFactoryEx extends AbstractProxyFactory {
	
	private HashMap<String, List<Method>> maps = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Invoker<T> invoker, Class<?>[] interfaces) {
		return (T) Proxy.getProxy(interfaces).newInstance(new InvokerInvocationHandler(invoker));
	}

	public <T> Invoker<T> getInvoker(T proxy, Class<T> type, URL url) {
		// TODO Wrapper类不能正确处理带$的类名
		final Wrapper wrapper = Wrapper
				.getWrapper(proxy.getClass().getName().indexOf('$') < 0 ? proxy.getClass() : type);
		return new AbstractProxyInvoker<T>(proxy, type, url) {

			@Override
			protected Object doInvoke(T proxy, String methodName, Class<?>[] parameterTypes, Object[] arguments)
					throws Throwable {
				if(parameterTypes == null)
				{
					parameterTypes = new Class<?>[0];
				}
				if(arguments == null)
				{
					arguments = new Object[0];
				}
				List<Method> ms = null;
				String mapkey = proxy.getClass() + ".." + methodName;
				synchronized(maps)
				{
					ms = maps.get(mapkey);
					if(ms == null)
					{
						ms = new ArrayList<>();
						Method[] mms = ReflectionUtils.getAllDeclaredMethods(proxy.getClass());
						for(Method m : mms)
						{
							if(StringUtils.equals(m.getName(), methodName))
							{
								ms.add(m);
							}
						}
						maps.put(mapkey, ms);
					}
				}
				
				Method m = null;
				for(Method mm : ms)
				{
					if(isSamMethod(mm,methodName,parameterTypes))
					{
						m = mm;
						break;
					}
				}
				if(m == null && !ms.isEmpty())
				{
					m = ms.get(0);
					if(m != null && m.getParameterTypes().length != parameterTypes.length)
					{
						parameterTypes = m.getParameterTypes();
						Object[] oldarguments = arguments;
						arguments = new Object[parameterTypes.length];
						int len = oldarguments.length > arguments.length ? arguments.length : oldarguments.length;
						for(int i = 0; i < len;i++)
						{
							arguments[i] = oldarguments[i];
						}
					}
				}
				return wrapper.invokeMethod(proxy, methodName, parameterTypes, arguments);
			}
		};
	}
	
	private static boolean isSamMethod(Method method,String methodName,Class<?>[] parameterTypes)
	{
	
		if(StringUtils.equals(methodName, method.getName()) && (parameterTypes == null || Arrays.equals(parameterTypes, method.getParameterTypes()))) 
		{
			return true;
		}
		return false;
		
	}
	
}

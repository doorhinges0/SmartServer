package com.sunrise.common.aspect;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.common.cache.redis.handler.RedisManager;
import org.apache.commons.lang.reflect.MethodUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisRefreshAspect {

	static Logger logger = LoggerFactory.getLogger(RedisRefreshAspect.class);
	private RedisManager manager;
	
	public RedisManager getManager() {
		return manager;
	}


	public void setManager(RedisManager manager) {
		this.manager = manager;
	}


	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		List<Object> srcVOList = null;
		if (methodName.equals("deleteByExample")){//对于批量删除的方法，先保存待删除的对象
			srcVOList = (List<Object>)MethodUtils.invokeMethod(joinPoint.getTarget(), "selectByExample", new Object[]{args[0]});
		}
		
		Object resutl = joinPoint.proceed();
		
		//如果修改的数据在redis中存在备份，则刷新缓存
		if (methodName.equals("insert") || methodName.equals("insertSelective") || methodName.equals("updateByPrimaryKeySelective") 
				|| methodName.equals("updateByPrimaryKeyWithBLOBs") || methodName.equals("updateByPrimaryKey") || methodName.equals("deleteByPrimaryKey")){
			int cnt = (Integer)resutl;
			if (cnt > 0){//数量大于0，代表有记录变动
				Object vo = args[0];
				List<Object> voList = new ArrayList<Object>();
				voList.add(vo);
				manager.refresh(voList,null);//刷新缓存
			}
		}else if (methodName.equals("updateByExampleSelective") || methodName.equals("updateByExample") || methodName.equals("updateByExampleWithBLOBs")){
			int cnt = (Integer)resutl;
			if (cnt > 0){//数量大于0，代表有记录变动
				List<Object> voList = (List<Object>)MethodUtils.invokeMethod(joinPoint.getTarget(), "selectByExample", new Object[]{args[1]});
				manager.refresh(voList,null);
			}
		}else if (methodName.equals("deleteByExample")){
			int cnt = (Integer)resutl;
			if (cnt > 0){//数量大于0，代表有记录变动
				manager.refresh(srcVOList,null);
			}
		}
		
		return resutl;
	}

}

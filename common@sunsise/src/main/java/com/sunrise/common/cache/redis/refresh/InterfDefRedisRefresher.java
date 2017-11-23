package com.sunrise.common.cache.redis.refresh;

import java.util.List;

import com.sunrise.common.model.config.InterfDefFacade;
import com.sunrise.common.utils.SpringCtxUtils;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.config.CommonConfig;
import com.sunrise.ucp.dal.gen.model.InterfdefVO;

public class InterfDefRedisRefresher implements RedisRefresher {

	@Override
	public void refreshCache(List<?> voList){
		if (CollectionUtils.isNotEmpty(voList)){
			CommonConfig.disableRedisCacheGet();//开始刷新缓存
			InterfDefFacade idf = SpringCtxUtils.getBean(InterfDefFacade.class);
			for (Object obj : voList) {
				if (obj instanceof InterfdefVO){
					InterfdefVO vo = (InterfdefVO)obj;
					idf.getInterDef(vo.getAppcode(),vo.getInterfclass(),vo.getMethodname());
				}
			}
			
			CommonConfig.enableRedisCache();//结束刷新缓存
		}
	}

}

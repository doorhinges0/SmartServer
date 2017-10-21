package com.dtsjy.mdboss.common.cache.redis.refresh;

import java.util.List;

import com.dtsjy.mdboss.common.model.config.InterfDefFacade;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.config.CommonConfig;
import com.dtsjy.mdboss.ucp.dal.gen.model.InterfdefVO;

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

package com.sunrise.common.cache.redis.refresh;

import java.util.List;

import com.sunrise.common.dal.gen.model.SysParamVO;
import com.sunrise.common.model.code2name.Code2NameUtil;
import com.sunrise.common.model.config.CommonConfigFacade;
import com.sunrise.common.utils.SpringCtxUtils;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.config.CommonConfig;
import com.sunrise.ucp.dal.gen.model.DictItemVO;

public class CommonConfigRedisRefresher implements RedisRefresher {

	@Override
	public void refreshCache(List<?> voList){
		if (CollectionUtils.isNotEmpty(voList)){
			CommonConfig.disableRedisCacheGet();//开始刷新缓存
			CommonConfigFacade ff = SpringCtxUtils.getBean(CommonConfigFacade.class);
			for (Object obj : voList) {
				if (obj instanceof DictItemVO){
					DictItemVO vo = (DictItemVO)obj;
					ff.getDictItem(vo.getGroupcode(),vo.getDictcode());
					ff.getDictItems(vo.getGroupcode(),null);
					ff.getAppDictItems(vo.getGroupcode(),Code2NameUtil.surmiseAppCode(null, vo.getGroupcode()),null);
				}else if (obj instanceof SysParamVO){
					SysParamVO vo = (SysParamVO)obj;
					ff.getUCPParamValue(vo.getParamcode(), vo.getAppcode());
					ff.getUCPSysParam(vo.getParamcode(),vo.getAppcode());
				}
			}
			
			CommonConfig.enableRedisCache();//结束刷新缓存
		}
	}
}

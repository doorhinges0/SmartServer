package com.dtsjy.mdboss.common.cache.redis.refresh;

import java.util.List;

import com.dtsjy.mdboss.common.dal.gen.model.SysParamVO;
import com.dtsjy.mdboss.common.model.code2name.Code2NameUtil;
import com.dtsjy.mdboss.common.model.config.CommonConfigFacade;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.config.CommonConfig;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;

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

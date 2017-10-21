package com.dtsjy.mdboss.common.cache.redis.refresh;

import java.util.List;

import com.dtsjy.mdboss.common.model.code2name.Code2NameFacade;
import com.dtsjy.mdboss.common.model.code2name.Code2NameUtil;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.config.CommonConfig;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;

public class Code2NameRedisRefresher implements RedisRefresher {

	@Override
	public void refreshCache(List<?> voList){
		if (CollectionUtils.isNotEmpty(voList)){
			CommonConfig.disableRedisCacheGet();//开始刷新缓存
			String userCode = CommonConfig.getEnvUserCode();
			Code2NameFacade cf = SpringCtxUtils.getBean(Code2NameFacade.class);
			for (Object obj : voList) {
				if (obj instanceof DictItemVO){
					DictItemVO vo = (DictItemVO)obj;
					String appCode = Code2NameUtil.surmiseAppCode(null, vo.getGroupcode());
					appCode = UcpModel.APP_CODE.value();
					cf.appCode2Name(appCode,vo.getGroupcode(),vo.getDictcode(),userCode);
					cf.appCode2NameValueList(appCode,vo.getGroupcode(),userCode);
					SpringCtxUtils.getBean(CommonConfigRedisRefresher.class).refreshCache(voList);//刷新commonconfig中涉及字典参数部分
				}
			}
			
			CommonConfig.enableRedisCache();//结束刷新缓存
		}
	}
}

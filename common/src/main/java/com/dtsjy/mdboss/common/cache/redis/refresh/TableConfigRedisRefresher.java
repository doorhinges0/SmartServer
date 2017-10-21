package com.dtsjy.mdboss.common.cache.redis.refresh;

import java.util.List;

import com.dtsjy.mdboss.common.model.config.TableConfigFacade;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.config.CommonConfig;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableColumnConfigVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableConfigVO;

public class TableConfigRedisRefresher implements RedisRefresher {

	@Override
	public void refreshCache(List<?> voList){
		if (CollectionUtils.isNotEmpty(voList)){
			CommonConfig.disableRedisCacheGet();//开始刷新缓存
//			queryAllTableConfig();
//			queryAllTableConfigColumn();
			TableConfigFacade tf = SpringCtxUtils.getBean(TableConfigFacade.class);
			for (Object obj : voList) {
				if (obj instanceof TableConfigVO){
					TableConfigVO vo = (TableConfigVO)obj;
//					queryOneTableConfig(vo.getVoname());
					tf.queryTableConfigColumn(vo.getVoname(),true);
					tf.queryTableConfigColumn(vo.getVoname(),false);
					tf.queryTableConfigColumn(vo.getVoname(),UcpModel.TABLE_COLUMNTYPE_DEF.value());
					tf.queryTableConfigColumn(vo.getVoname(),UcpModel.TABLE_COLUMNTYPE_EXT.value());
				}else if (obj instanceof TableColumnConfigVO){
					TableColumnConfigVO vo = (TableColumnConfigVO)obj;
//					queryOneTableConfig(vo.getVoname());
					tf.queryTableConfigColumn(vo.getVoname(),true);
					tf.queryTableConfigColumn(vo.getVoname(),false);
					tf.queryTableConfigColumn(vo.getVoname(),UcpModel.TABLE_COLUMNTYPE_DEF.value());
					tf.queryTableConfigColumn(vo.getVoname(),UcpModel.TABLE_COLUMNTYPE_EXT.value());
				}
			}
			
			CommonConfig.enableRedisCache();//结束刷新缓存
		}
	}

}

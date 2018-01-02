package com.rfc.spider.dao;


import com.rfc.spider.entity.DomesticDataEntity;
import com.rfc.spider.entity.Testclass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public interface DomesticDataDao {

    public int batchInsert(@Param("list")List<DomesticDataEntity> list);

    public int oneInsert(@Param("item")DomesticDataEntity item);

    public DomesticDataEntity getOneRecord();

}

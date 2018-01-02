package com.rfc.spider.dao;

import com.rfc.spider.entity.DomesticData;
import com.rfc.spider.entity.DomesticDataEntity;
import com.rfc.spider.entity.DomesticDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomesticDataMapper {
    int batchInsert(@Param("list")List<DomesticDataEntity> list);

    int countByExample(DomesticDataExample example);

    int deleteByExample(DomesticDataExample example);

    int insert(DomesticData record);

    int insertSelective(DomesticData record);

    List<DomesticData> selectByExample(DomesticDataExample example);

    int updateByExampleSelective(@Param("record") DomesticData record, @Param("example") DomesticDataExample example);

    int updateByExample(@Param("record") DomesticData record, @Param("example") DomesticDataExample example);
}
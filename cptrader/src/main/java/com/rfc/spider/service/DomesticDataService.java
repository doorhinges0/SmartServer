package com.rfc.spider.service;

import com.rfc.spider.entity.DomesticData;
import com.rfc.spider.entity.DomesticDataEntity;
import com.rfc.spider.entity.DomesticDataExample;
import com.rfc.spider.entity.Testclass;

import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public interface DomesticDataService {


    public int saveRecords(List<DomesticDataEntity> domesticDataEntityList);

    public int saveOneRecord(DomesticDataEntity domesticDataEntity);

    public DomesticDataEntity getOneRecord();

    public int saveOneRecordByGen(DomesticData domesticDataEntity) ;

    public int saveRecordsByGen(List<DomesticDataEntity> domesticDataEntityList);

    public  List<DomesticData> selectByExample(DomesticDataExample example);

}

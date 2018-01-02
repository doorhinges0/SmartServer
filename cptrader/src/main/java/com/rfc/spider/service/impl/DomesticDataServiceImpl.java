package com.rfc.spider.service.impl;

import com.rfc.spider.dao.DomesticDataDao;
import com.rfc.spider.dao.DomesticDataMapper;
import com.rfc.spider.entity.DomesticData;
import com.rfc.spider.entity.DomesticDataEntity;
import com.rfc.spider.entity.DomesticDataExample;
import com.rfc.spider.service.DomesticDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
@Service
public class DomesticDataServiceImpl implements DomesticDataService{

    @Resource
    private DomesticDataDao domesticDataDao;

    @Resource
    private DomesticDataMapper domesticDataMapper;

    @Override
    public int saveRecords(List<DomesticDataEntity> domesticDataEntityList) {

        int  result = domesticDataDao.batchInsert(domesticDataEntityList);
        return result;
    }

//    @Transactional(rollbackFor = Exception.class)
    @Transactional
    public int saveOneRecord(DomesticDataEntity domesticDataEntity) {
        int  result = domesticDataDao.oneInsert(domesticDataEntity);
        return result;
    }

    public DomesticDataEntity getOneRecord(){
        DomesticDataEntity  ret = domesticDataDao.getOneRecord();
        return ret;
    }

    public int saveOneRecordByGen(DomesticData domesticDataEntity) {
        int  result = domesticDataMapper.insert(domesticDataEntity);
        return result;
    }

    @Override
    public int saveRecordsByGen(List<DomesticDataEntity> domesticDataEntityList) {
        int  result = domesticDataMapper.batchInsert(domesticDataEntityList);
        return result;
    }

    public  List<DomesticData> selectByExample(DomesticDataExample example){
        List<DomesticData> result= domesticDataMapper.selectByExample(example);
        return result;
    }

}

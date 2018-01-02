package com.rfc.spider.service;

import com.rfc.spider.dao.TestDao;
import com.rfc.spider.entity.DomesticDataEntity;
import com.rfc.spider.entity.Testclass;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public interface TestService {

    public List<Testclass> listAllRecords();

    public Testclass getOneRecord();

    public int saveOneRecord(Testclass domesticDataEntity);

}

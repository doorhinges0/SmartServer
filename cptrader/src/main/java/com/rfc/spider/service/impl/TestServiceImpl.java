package com.rfc.spider.service.impl;

import com.rfc.spider.dao.TestDao;
import com.rfc.spider.entity.Testclass;
import com.rfc.spider.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
@Service
public class TestServiceImpl  implements TestService {

    @Resource
    private TestDao testDao;

    public List<Testclass> listAllRecords() {
        return testDao.listAllRecords();
    }
    public Testclass getOneRecord() {
        return testDao.getOneRecord();
    }

    @Override
//    @Transactional
    public int saveOneRecord(Testclass domesticDataEntity) {
        int  result = testDao.oneInsert(domesticDataEntity);
        return result;
    }

}

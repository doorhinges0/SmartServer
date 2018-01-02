package com.rfc.spider.dao;


import com.rfc.spider.entity.Testclass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public interface TestDao {

    public List<Testclass> listAllRecords();

    public Testclass getOneRecord();

    public int oneInsert(@Param("item")Testclass item);
}

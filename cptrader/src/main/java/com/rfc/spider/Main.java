package com.rfc.spider;

import com.rfc.spider.entity.DomesticData;
import com.rfc.spider.entity.DomesticDataEntity;
import com.rfc.spider.entity.DomesticDataExample;
import com.rfc.spider.entity.Testclass;
import com.rfc.spider.service.DomesticDataService;
import com.rfc.spider.service.TestService;
import com.rfc.spider.service.impl.DomesticDataServiceImpl;
import com.rfc.spider.service.impl.TestServiceImpl;
import com.rfc.util.common.DateToolkit;
import com.rfc.util.spring.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/12/31.
 */
public class Main {

    public static void main(String[]  args){


        ApplicationContext springApplication=new ClassPathXmlApplicationContext("classpath*:spring/spring-applicationContext.xml");

//        ApplicationContext springApplication =  SpringContextUtil.getApplicationContext();
//        String[] ctx = springApplication.getBeanDefinitionNames();
//获得所有容器中初始的bean
        String[] beanNames = springApplication.getBeanDefinitionNames();
//打印出所有bean
        List<String> list = Arrays.asList(beanNames);

        TestService testService = (TestService)springApplication.getBean(TestServiceImpl.class);

//        Testclass result = testService.getOneRecord();

        Testclass testclass = new Testclass();
        testclass.setId(124L);
        testclass.setName("124name");
//        int resultInt = testService.saveOneRecord(testclass);



        System.out.println("test_sqlite_结束标识"); //输出内容


        DomesticDataService domesticDataService = (DomesticDataService)springApplication.getBean("domesticDataServiceImpl");

        DomesticDataEntity ret = domesticDataService.getOneRecord( );
        System.out.println("test_sqlite_结束标识"); //输出内容

        List<DomesticDataEntity> domesticDataEntityList = new ArrayList<DomesticDataEntity>();
        String yyyyMMddHHmmss = DateToolkit.todayStr(null);
        for ( int j = 0; j < 2; j++){
            DomesticDataEntity domesticDataEntity = new DomesticDataEntity();
            domesticDataEntity.setBatchno(Long.valueOf(yyyyMMddHHmmss));
            domesticDataEntity.setCompany("domestic");
            domesticDataEntity.setSeqtime(String.valueOf(j));
            domesticDataEntity.setTeam(String.valueOf(3*j) + "team");
            domesticDataEntity.setBiztype(j+1);
            domesticDataEntity.setHandicap(Integer.valueOf("0"));
            domesticDataEntity.setWratio(Double.valueOf((5*j +1)));
            domesticDataEntity.setDratio(Double.valueOf((5*j +2)));
            domesticDataEntity.setLratio(Double.valueOf((5*j +3)));
            domesticDataEntityList.add(domesticDataEntity);
        }

//        int result = testService.saveRecords( domesticDataEntityList);
//        int result = domesticDataService.saveOneRecord( domesticDataEntityList.get(0));
        System.out.println("test_sqlite_结束标识"); //输出内容

        DomesticData domesticData = new DomesticData();
        domesticData.setBatchno(Long.valueOf(yyyyMMddHHmmss));
        domesticData.setCompany("DomesticData");
        domesticData.setTeam(String.valueOf(3*6) + "team");
        domesticData.setBiztype(6+1);
        domesticData.setHandicap(Integer.valueOf("0"));
        domesticData.setWratio(Double.valueOf((5*6 +1)));
        domesticData.setDratio(Double.valueOf((5*6 +2)));
        domesticData.setLratio(Double.valueOf((5*6 +3)));

//        int ret2 = domesticDataService.saveOneRecordByGen(domesticData);

        System.out.println("test_sqlite_结束标识"); //输出内容

        DomesticDataExample example = new DomesticDataExample();
        example.createCriteria().andCompanyEqualTo("DomesticData");
        List<DomesticData> ret3 = domesticDataService.selectByExample( example);
        System.out.println("test_sqlite_结束标识"); //输出内容

        DomesticDataExample exampleOrder = new DomesticDataExample();
        exampleOrder.setOrderByClause( "  createdate desc ");
        List<DomesticData> ret4 = domesticDataService.selectByExample( exampleOrder);
        System.out.println("test_sqlite_结束标识"); //输出内容

        DomesticDataExample exampleOrder2 = new DomesticDataExample();
        exampleOrder2.setOrderByClause( "  createdate asc ");
        List<DomesticData> ret5 = domesticDataService.selectByExample( exampleOrder2);
        System.out.println("test_sqlite_结束标识"); //输出内容

    }

}

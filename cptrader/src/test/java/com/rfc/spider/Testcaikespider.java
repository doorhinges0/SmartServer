package com.rfc.spider;

import com.rfc.spider.entity.DomesticDataEntity;
import com.rfc.spider.entity.Testclass;
import com.rfc.spider.service.DomesticDataService;
import com.rfc.spider.service.TestService;
import com.rfc.spider.service.impl.DomesticDataServiceImpl;
import com.rfc.spider.service.impl.TestServiceImpl;
import com.rfc.util.FileToolkit;
import com.rfc.util.common.DateToolkit;
import com.rfc.util.spring.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21.
 */

@ContextHierarchy({
        @ContextConfiguration(locations = "classpath*:spring/spring-applicationContext.xml")
})
public class Testcaikespider extends AbstractTestNGSpringContextTests {

    @Test
    public void test_caikeSpider(){

        List list1 = new ArrayList();
        for ( int i = 0; i < 10; i++)
            list1.add(i);

        System.out.println("Wake up: " + list1.size()%5) ;
        System.out.println("Wake up: " + list1.size()/5) ;
        for ( int j = 0; j < list1.size()/5; j++)
            list1.add(j);

        ApplicationContext springApplication =  SpringContextUtil.getApplicationContext();
//        String[] ctx = springApplication.getBeanDefinitionNames();
//获得所有容器中初始的bean
        String[] beanNames = springApplication.getBeanDefinitionNames();
//打印出所有bean
        List<String> list = Arrays.asList(beanNames);

        CaikeSpider caikeSpider = (CaikeSpider)springApplication.getBean(CaikeSpider.class);
//        CaikeSpider caikeSpider = (CaikeSpider)springApplication.getBean("caikeSpider")/*new CaikeSpider()*/;
//        caikeSpider.init();
//        caikeSpider.initAjax();



        //  沉睡3分钟
        while (true){
            try
            {
                String yyyyMMddHHmmss = DateToolkit.todayStr(null);
                long startTime = System.currentTimeMillis();
                caikeSpider.try3crawler();

                String teamAndBatchno = "西汉姆联_VS_西布罗姆维奇"+"|"+yyyyMMddHHmmss+"|"+"星期二003";
                String url = "http://www.310win.com/analysis/1395295.htm";

//                caikeSpider.asynSpider(teamAndBatchno, url);

                long endTime = System.currentTimeMillis();
                System.out.println("Testcaikespider_结束标识"+ ", costtime(毫秒):" + String.valueOf(endTime - startTime)); //输出内容

                System.out.println("Start to sleep: " +  DateToolkit.todayTime(null));
                int sleepTime = 5*60*1000;
                Thread.sleep(sleepTime);
                //Thread.sleep(60*1000);
                System.out.println("Wake up: " +  DateToolkit.todayTime(null)) ;
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

//        String str = huobi.getNotice();
//        System.out.println(str); //输出内容
//        System.out.println("Testcaikespider_结束标识"); //输出内容

    }

    @Rollback(false)
//    @Test
    public void testbatch_sqlite(){

        ApplicationContext springApplication =  SpringContextUtil.getApplicationContext();
//        String[] ctx = springApplication.getBeanDefinitionNames();
//获得所有容器中初始的bean
        String[] beanNames = springApplication.getBeanDefinitionNames();
//打印出所有bean
        List<String> list = Arrays.asList(beanNames);
        DomesticDataService testService = (DomesticDataService)springApplication.getBean(DomesticDataServiceImpl.class);
        List< DomesticDataEntity > domesticDataEntityList = new ArrayList<DomesticDataEntity>();
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
        int result = testService.saveOneRecord( domesticDataEntityList.get(0));
        System.out.println("test_sqlite_结束标识"); //输出内容


    }

//    @Test
    public void test_sqlite(){

        ApplicationContext springApplication =  SpringContextUtil.getApplicationContext();
//        String[] ctx = springApplication.getBeanDefinitionNames();
//获得所有容器中初始的bean
        String[] beanNames = springApplication.getBeanDefinitionNames();
//打印出所有bean
        List<String> list = Arrays.asList(beanNames);

        TestService testService = (TestService)springApplication.getBean(TestServiceImpl.class);

//        Testclass result = testService.getOneRecord();

        List<Testclass> result = testService.listAllRecords();



        System.out.println("test_sqlite_结束标识"); //输出内容


    }


}

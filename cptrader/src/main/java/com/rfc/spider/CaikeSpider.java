package com.rfc.spider;


import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.rfc.spider.entity.DomesticDataEntity;
import com.rfc.spider.service.DomesticDataService;
import com.rfc.util.FileToolkit;
import com.rfc.util.common.DateToolkit;
import com.rfc.util.common.DateUtils;
import com.rfc.util.http.HttpUtils;
import com.rfc.util.http.ResponseWrap;
import com.rfc.util.thread.CustomThreadPool;
import com.rfc.util.thread.DataAdapterResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.*;

//import org.htmlparser.visitors.HtmlPage;


/**
 * Created by Administrator on 2017/11/21.
 */
@Component
public class CaikeSpider {

//    @Resource
    @Autowired
    @Qualifier(value = "customThreadPool")
    private CustomThreadPool threadPool;

    @Autowired
    @Qualifier(value = "domesticDataServiceImpl")
    private DomesticDataService domesticDataService;

    Map<String,String> mapXi = new ConcurrentHashMap<String,String>();
    List<DomesticDataEntity> domesticDataEntityList = new ArrayList<DomesticDataEntity>();

    public  void try3crawler(){

        boolean  successed = false;
        int  retryTimes = 3 ;

        while ((!successed) && (retryTimes > 0)){
            boolean successedNext  = initAjax();
            retryTimes--;
            System.out.println("主线程retryTimes" + retryTimes );
            successed = successedNext;
            if ( !successed){
                System.out.println("主线程异常了," + successed + " sleep(6*1000)");
                try {
                    Thread.sleep(6*1000);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }

        if ( !successed){
            System.out.println("主线程异常了," + successed + " sleep(3*1000)");
            try {
                Thread.sleep(3*1000);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if (( mapXi.size() > 0)){
            System.out.println("析的总共size的：" + mapXi.size());
            for (Map.Entry<String, String> one : mapXi.entrySet() ) {
                System.out.println( one.getKey() + " links " + one.getValue());
            }

            boolean  successedXI = false;
            int  retryTimesXI = 3 ;

            while ((!successedXI) && (retryTimesXI > 0)){
                boolean successedNext  = asyncBatchInvoke( mapXi);;
                retryTimesXI--;
                System.out.println("析的主线程retryTimes:" + retryTimesXI + ",successedNext:"+ successedNext );

                successedXI = successedNext;
                if ( !successed){
                    System.out.println("析的主线程异常了,"+successedXI+",successedNext:"+ successedNext +" sleep(6*1000)");
                    try {
                        Thread.sleep(6*1000);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("析的主线程异常了,"+successedXI+ ",successedNext:"+ successedNext +" sleep(6*1000) , wakeup");
                }
            }
            System.out.println("析的while主线程出来了retryTimes:" + retryTimesXI + ",successedXI:"+ successedXI );

        }
        return ;
    }

    public boolean initAjax()
    {

        domesticDataEntityList.clear();

        // 创建模拟浏览器，参数可以指定不同类型的浏览器
        WebClient webClient = new WebClient();

        // 启用JS解释器，默认为true
//        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setJavaScriptEnabled(false);

        // 禁用css支持
        webClient.getOptions().setCssEnabled(false);

        // js运行错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        // 设置超时
        webClient.getOptions().setTimeout(900000);

        String url = "http://www.310win.com/buy/Jingcai.aspx?TypeID=105&OddsType=2";

        boolean  successed = true;
        try {

            // page 就是你获取到的html，你可以进一步的解析数据
            HtmlPage page = webClient.getPage(url);

            // 这里我会使用Jsoup对html页面进行解析
            Document document = Jsoup.parse(page.asXml(), "UTF-8");

            String yyyyMMddHHmmss = DateToolkit.todayStr(null);

            Elements trs = document.select("tbody").select("tr");
            for (int  i=12; i<trs.size(); )
            {

                Elements tds = trs.get(i).select("tr");
                String date = tds.attr("name");
                System.out.println("date"+ date );

                String changci = tds.get(0).select("td").get(0).text();
                System.out.println("changci"+ changci );

                String id = tds.get(0).attr("id");
                Elements links = tds.get(0).select("a");
                System.out.println( "========"+i);
                if (i == 153)
                    System.out.println("test");
                if ( "隐藏 显示".equals(links.text()) ){
                    System.out.println(links.text());
                    i = i+ 1;
                }
                else if ("截止 开赛".equals(links.text())){
                    System.out.println("break" + links.text());
                    break;
                }
                else{

                    String vs = links.get(1).select("a").first().text() + "_VS_" +  links.get(2).select("a").first().text();
                    System.out.println(vs);
                    Output2File(vs);

                    System.out.println("td[0]"+ links.text());
                    Elements tdHandicap = tds.select("tbody").select("td");

                    for ( int j = 0; j < tdHandicap.size()/5; j++){
                        int m = 0;
                        if ( tdHandicap.size()/5 ==1 )
                            m =  1;
                        DomesticDataEntity domesticDataEntity = new DomesticDataEntity();
                        domesticDataEntity.setBatchno(Long.valueOf(yyyyMMddHHmmss));
                        domesticDataEntity.setCompany("domestic");
                        domesticDataEntity.setSeqtime(date+changci);
                        domesticDataEntity.setTeam(vs);
                        domesticDataEntity.setBiztype(j + m);
                        String handicap = tdHandicap.get(5*j ).text().replaceAll("[\\u00A0]+", "");
                        if ( tdHandicap.size()/5 ==1 )
                            handicap = tdHandicap.get(5*j + m).text().replaceAll("[\\u00A0]+", "");
                        if (handicap.isEmpty()){
                            domesticDataEntity.setHandicap(Integer.valueOf("0"));
                        }
                        else{
                            domesticDataEntity.setHandicap(Integer.valueOf(handicap));
                        }

                        domesticDataEntity.setWratio(Double.valueOf(tdHandicap.get(5*j + m +1).text()));
                        domesticDataEntity.setDratio(Double.valueOf(tdHandicap.get(5*j + m +2).text()));
                        domesticDataEntity.setLratio(Double.valueOf(tdHandicap.get(5*j + m +3).text()));
                        domesticDataEntityList.add(domesticDataEntity);
                    }

//                    for (int handicap = 0 ; handicap < tdHandicap.size(); handicap++){
//                        //    domestic|Monday003|1|0|2.95|3.05|2.19| domestic|Monday003|2|+1|1.52|3.75|4.90
//                        String colum = tdHandicap.get(handicap).text().replaceAll("[\\u00A0]+", "");
//                        System.out.println("==========colum==="+colum+"=======");
//
//                    }

                    Element link = links.get(5).select("a").first();
                    if ( link != null){
                        String linkText = link.text();
                        String linkHref = "http://www.310win.com" + link.attr("href");

                        mapXi.put(vs+"|"+yyyyMMddHHmmss+"|"+date+changci, linkHref);
//                        asynSpider(linkHref);
                        System.out.println(linkText);
                    }
                    i = i+ 3;
                }
            }
//            domesticDataService.saveRecords(domesticDataEntityList);
            int ret = domesticDataService.saveRecordsByGen(domesticDataEntityList);
            System.out.println("saveRecordsByGen");
        }
        catch (Exception e)
        {
            successed = false;
            System.out.println("主线程异常了");
            OutputExceptionLog(e.toString());
            e.printStackTrace();

            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }

        return successed;
    }


    /**
     * 并行调用数据适配层
     *
     * @param taskMap 数据适配层任务映射表 fieldSetId => RuleEngineFieldBean
     * @return Map 并行调用后逾期结果列表 Map<String, JSONObject>
     */
    private boolean asyncBatchInvoke(Map<String, String> taskMap) {
        domesticDataEntityList.clear();
        //批量任务提交服务
        CompletionService<DataAdapterResult> completionService
                = new ExecutorCompletionService<DataAdapterResult>(threadPool.getExecutorService());
        //迭代任务
        Iterator<Map.Entry<String, String>> taskIterator = taskMap.entrySet().iterator();
        for (; taskIterator.hasNext(); ) {
            final Map.Entry<String, String> entry = taskIterator.next();
            try {
                completionService.submit(new Callable<DataAdapterResult>() {
                    public DataAdapterResult call() throws Exception {
                        DataAdapterResult output = new DataAdapterResult(entry.getKey(), null);
                        long startTime = System.currentTimeMillis();
                        JSONObject result = asynSpider(entry.getKey(), entry.getValue());
                        System.out.println("采集服务ID:"+  entry.getKey()+"RPC耗时毫秒:"+ String.valueOf(System.currentTimeMillis() - startTime));
                        output.setResult(result);
                        return output;
                    }
                });
            } catch (Exception e) {
                OutputExceptionLog(e.toString());
                e.printStackTrace();
            }
        }

        //取结果
        Map<String, JSONObject> ret = getFutureResult(completionService, taskMap.size());

        System.out.println("没有完成的：" + mapXi.size());
        for (Map.Entry<String, String> one : mapXi.entrySet() ) {
            System.out.println( one.getKey() + " links " + one.getValue());
        }

        int retSave = domesticDataService.saveRecordsByGen(domesticDataEntityList);
        System.out.println(" saveRecordsByGen成功保存: " + retSave + " 条");

        return (mapXi.size()< 1);
    }



    private Map<String, JSONObject> getFutureResult(
            CompletionService<DataAdapterResult> completionService, int taskCount) {
        //取数据总共耗时
        long startTime = System.currentTimeMillis();
        Map<String, JSONObject> futureResultMap = new TreeMap<String, JSONObject>();
        for (int i = 0; i < taskCount; i++) {
            //记录每个任务耗时
            long startTimeSingle = System.currentTimeMillis();
            Future<DataAdapterResult> futureTask = null;
            DataAdapterResult futureResult = null;
            try {
                futureTask = completionService.take();
                futureResult = futureTask.get();
            } catch (InterruptedException ex) {
                OutputExceptionLog("数据服务Interrupted异常: {}"+ ex.toString());
                System.out.println("数据服务Interrupted异常: {}"+ ex.getMessage());
                if (futureTask != null) {
                    futureTask.cancel(true);
                }
            } catch (ExecutionException ex) {
                OutputExceptionLog("数据服务Execution异常: {}"+ex.toString());
                System.out.println("数据服务Execution异常: {}"+ ex.getMessage());
                futureTask.cancel(true);
            } finally {
                long costTimeSingle = System.currentTimeMillis() - startTimeSingle;
                if (futureResult != null) {
                    JSONObject jsonObject = futureResult.getResult();
                    System.out.println("数据服务ID: "+ futureResult.getKey() +",JSONObjectsuccess："+ jsonObject.get("success"));
                    if (((Boolean)jsonObject.get("success"))){
                        System.out.println("数据服务ID: "+ futureResult.getKey() +",success："+ jsonObject.get("success"));
                        mapXi.remove(futureResult.getKey());
                    }
                    Output2File("数据服务ID: "+ futureResult.getKey() +", TAKE耗时毫秒："+ String.valueOf(costTimeSingle)+", 结果:"+ futureResult);
                    System.out.println("数据服务ID: "+ futureResult.getKey() +", TAKE耗时毫秒："+ String.valueOf(costTimeSingle)+", 结果:"+ futureResult);
                    futureResultMap.put(futureResult.getKey(), futureResult.getResult());

                } else {
                    OutputExceptionLog("数据服务ID: "+ null +", TAKE耗时毫秒："+ String.valueOf(costTimeSingle)+", 结果:"+ null);
                    System.out.println("数据服务ID: "+ null +", TAKE耗时毫秒："+ String.valueOf(costTimeSingle)+", 结果:"+ null);
                }
            }
        }

        System.out.println("数据服务取结果总耗时毫秒:" + String.valueOf(System.currentTimeMillis() - startTime));
        return futureResultMap;
    }


    public JSONObject asynSpider(String teamAndBatchno, String url)
    {

        JSONObject dataAdapterResp = new JSONObject();
        try {
//            String linkHref = "http://www.310win.com" + link.attr("href");


            WebClient xiwebClient = new WebClient();
            xiwebClient.getOptions().setJavaScriptEnabled(true);
//            xiwebClient.getOptions().setJavaScriptEnabled(false);
            xiwebClient.getOptions().setCssEnabled(false);
            xiwebClient.getOptions().setThrowExceptionOnScriptError(false);
            xiwebClient.getOptions().setTimeout(9000000);

            System.out.println(url);
            long startTime = System.currentTimeMillis();
            // page 就是你获取到的html，你可以进一步的解析数据
            HtmlPage pagexi = xiwebClient.getPage(url);
            long endTime = System.currentTimeMillis();
            System.out.println("cost time:" + String.valueOf(endTime - startTime));

            // 这里我会使用Jsoup对html页面进行解析
            Document documentxi = Jsoup.parse(pagexi.asXml());
            Elements trsxi = documentxi.getElementById("porlet_1").select("tr");
//            System.out.println(trsxi.text());
            String[] tb = teamAndBatchno.split("\\|");
            String company = "";
            for (int  j =2; j< 6/*trsxi.size()*/; j++)
            {
                Elements tdsxi = trsxi.get(j).select("td");
                String date = tdsxi.get(0).attr("class");
                if ("companyBg".equals(date)){
                    company = tdsxi.get(0).text();
                    continue;
                }
                System.out.println(tdsxi.text());
                Output2File(tdsxi.text());
//                for (int k=0; k<tdsxi.size(); k++){
//                    String attr = tdsxi.get(k).text();
//                    System.out.println(attr);
//                }

                if (tdsxi.size() < 10 )
                    continue;
                DomesticDataEntity domesticDataEntity = new DomesticDataEntity();
                domesticDataEntity.setBatchno(Long.valueOf(tb[1]));
                domesticDataEntity.setCompany("abroad");
                domesticDataEntity.setSubcompany(company);
                domesticDataEntity.setSeqtime(tb[2]);
                domesticDataEntity.setTeam(tb[0]);
                domesticDataEntity.setBiztype(3);
                domesticDataEntity.setWratio(Double.valueOf(tdsxi.get(1).text()));
                domesticDataEntity.setDratio(Double.valueOf(tdsxi.get(2).text()));
                domesticDataEntity.setLratio(Double.valueOf(tdsxi.get(3).text()));
                domesticDataEntity.setRatio1(Double.valueOf(tdsxi.get(8).text()));
                domesticDataEntity.setCahandicap(tdsxi.get(9).text());
                domesticDataEntity.setRatio2(Double.valueOf(tdsxi.get(10).text()));

                domesticDataEntityList.add(domesticDataEntity);

                if (j > 5)
                    break;
            }
            if (trsxi.size() >2 )
                dataAdapterResp.put("success", true);
            else
                dataAdapterResp.put("success", false);
//            System.out.println(linkText);
        }
        catch (Exception e)
        {
            dataAdapterResp.put("success", false);
            OutputExceptionLog(e.toString());
            e.printStackTrace();
        }

        return dataAdapterResp;
    }



    //  输出异常message到日志
    public void OutputExceptionLog(String exceptionMessage)
    {
        String Message = new String();
        if (exceptionMessage != null) {
            Message = "CaikeSpider, exception: " + exceptionMessage + ", time: " +  DateUtils.nowTimeStamp();
        }
        else {
            Message = "CaikeSpider, exception" + ", time: " +  DateUtils.nowTimeStamp();
        }
        String path = FileToolkit.getProjectPath4Log();
        String getNoticeFile = path + "ExceptionFile" + DateUtils.getReqDate() + ".log";
        FileToolkit.append2File(getNoticeFile, Message);

        return;
    }

    //  输出异常message到日志
    public void Output2File(String exceptionMessage)
    {
        String Message = new String();
        if (exceptionMessage != null) {
            Message = "CaikeSpider, message: " + exceptionMessage + ", time: " +  DateUtils.nowTimeStamp();
        }
        else {
            Message = "CaikeSpider, message" + ", time: " +  DateUtils.nowTimeStamp();
        }
        String path = FileToolkit.getProjectPath4Log();
        String getNoticeFile = path + "CaikeSpider" + DateUtils.getReqDate() + ".log";
        FileToolkit.append2File(getNoticeFile, Message);

        return;
    }


    public void initAjax2()
    {

        // 创建模拟浏览器，参数可以指定不同类型的浏览器
        WebClient webClient = new WebClient();

        // 启用JS解释器，默认为true
        webClient.getOptions().setJavaScriptEnabled(true);

        // 禁用css支持
        webClient.getOptions().setCssEnabled(false);

        // js运行错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        // 设置超时
        webClient.getOptions().setTimeout(900000);

        String url = "http://www.310win.com/buy/Jingcai.aspx?TypeID=105&OddsType=2";


        try {

            // page 就是你获取到的html，你可以进一步的解析数据
            HtmlPage page = webClient.getPage(url);

            // 这里我会使用Jsoup对html页面进行解析
            Document document = Jsoup.parse(page.asXml(), "UTF-8");


            Elements trs = document.select("tbody").select("tr");
            for (int  i=12; i<trs.size(); i = i+ 3)
            {
                Elements tds = trs.get(i).select("tr");
                String id = tds.get(0).attr("id");
//                for (int j=0; j<tds.size(); j++)
//                {
//                    Element link = tds.get(j).select("a").first();
                Elements links = tds.get(0).select("a");

                if ( links.size() < 2 ){
                    System.out.println(links.text());
                    continue;
                }

                String vs = links.get(1).select("a").first().text() + "_vs_" +  links.get(2).select("a").first().text();
                System.out.println(vs);
                Output2File(vs);

                Element link = links.get(5).select("a").first();
                if ( link != null){
                    String linkText = link.text();
                    String linkHref = "http://www.310win.com" + link.attr("href");


                    WebClient xiwebClient = new WebClient();
                    xiwebClient.getOptions().setJavaScriptEnabled(true);
                    xiwebClient.getOptions().setCssEnabled(false);
                    xiwebClient.getOptions().setThrowExceptionOnScriptError(false);
                    xiwebClient.getOptions().setTimeout(9000000);

                    System.out.println(linkHref);
                    long startTime = System.currentTimeMillis();
                    // page 就是你获取到的html，你可以进一步的解析数据
                    HtmlPage pagexi = xiwebClient.getPage(linkHref);
                    long endTime = System.currentTimeMillis();
                    System.out.println("cost time:" + String.valueOf(endTime - startTime));

                    // 这里我会使用Jsoup对html页面进行解析
                    Document documentxi = Jsoup.parse(pagexi.asXml());
//                        Elements trsxi = documentxi.select("porlet_1").select("tr");
                    Elements trsxi = documentxi.getElementById("porlet_1").select("tr");
//                        System.out.println(trsxi.text());
                    for (int  j =2; j<trsxi.size(); j++)
                    {
                        Elements tdsxi = trsxi.get(j).select("td");
                        System.out.println(tdsxi.text());
                        Output2File(tdsxi.text());
                        for (int k=0; k<tdsxi.size(); k++){
                            String attr = tdsxi.get(k).text();
//                                System.out.println(attr);
                        }
                    }
                    System.out.println(linkText);
                }
//                }
            }
        }
        catch (Exception e)
        {
            OutputExceptionLog(e.toString());
            e.printStackTrace();
        }


        return;
    }


}

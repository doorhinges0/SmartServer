package acquisition.timer;

import acquisition.context.Context;
import acquisition.output.OutPut;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.*;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;

import java.util.*;

/**
 * Copyrights @ 2011,Tianyuan DIC Information Co.,Ltd. All rights reserved.<br>
 *
 * @author 张伟
 * @description 执行采集核心程序入口
 * @date 2014-05-30 10:18
 */
public class AcquisitionTimerTask extends TimerTask {

    public Context context;

    private static String url = "http://www.310win.com";

    private final static Map<String, String> dayMapping = new HashMap<String, String>();



    /**
     * 需要抓取数据的公司名称
     */
    private final static Set<String> compaySet = new HashSet<String>();

    //private final static Map<String, String> wayOfPlaying = new HashMap<String, String>();
    private final static Map<String, String> wayOfPlaying = new TreeMap<String, String>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    static {
        dayMapping.put("周一", "Mon");
        dayMapping.put("周二", "Tue");
        dayMapping.put("周三", "Wed");
        dayMapping.put("周四", "Thu");
        dayMapping.put("周五", "Fri");
        dayMapping.put("周六", "Sat");
        dayMapping.put("周日", "Sun");

        compaySet.add("ＳＢ");
        compaySet.add("Bet365");

        wayOfPlaying.put("single", url + "/buy/jingcai.aspx?typeID=105&oddstype=1");
        wayOfPlaying.put("double", url + "/buy/jingcai.aspx?typeID=105&oddstype=2");
    }

    private final static String domesticStr = "domestic";

    private final static String abroadStr = "abroad";

    @Override
    public void run() {
        if (!OutPut.isRun(context)) {
            //System.out.println("检测到source_file.txt文件已存在，程序退出！时间：" + OutPut.getCurrentDay("yyyyMMdd_HHmmss") );
            System.out.println("检测到source_file.txt文件已存在，等待下一次检测！时间：" + OutPut.getCurrentDay("yyyyMMdd_HHmmss") );
            return;
        }
        //开始采集
        System.out.println("开始执行采集程序，时间：" + OutPut.getCurrentDay("yyyyMMdd_HHmmss") );

        parse(wayOfPlaying);

        System.out.println("采集完成，等待下一次采集，时间：" + OutPut.getCurrentDay("yyyyMMdd_HHmmss") );
    }


    /**
     * 采集程序核心方法
     */
    public void parse(Map<String, String> wayOfPlaying) {
        //胜平负链接
        //String startUrl = url + "/buy/jingcai.aspx?typeID=105&oddstype=2";
        OutPut outPut = new OutPut( context);

        Iterator it = wayOfPlaying.keySet().iterator();
        while( it.hasNext() )
        {
            String playingway = it.next().toString();
            String startUrl = wayOfPlaying.get(playingway);

            try {


                NodeFilter filter = new NodeClassFilter(TableTag.class);
                Parser parser = new Parser();
                parser.setURL(startUrl);
                parser.setEncoding(parser.getEncoding());
                NodeList list = parser.extractAllNodesThatMatch(filter);
                List<List> datas = new ArrayList<List>();
                for (int i = 0; i < list.size(); i++) {
                    TableTag node = (TableTag) list.elementAt(i);
                    String id = node.getAttribute("id");
                    if (id != null && id.equals("MatchTable")) {
                        TableRow[] tableRows = node.getRows();
                        //每日的足球比赛表格栏，数据从第4个tr开始
                        for (int j = 0; j < tableRows.length; j++) {
                            List rowData = new ArrayList();
                            //盘口数据
                            int andicaph = 1;
                            //每一行的数据
                            TableRow tableRow = tableRows[j];
                            String className = tableRow.getAttribute("class");
                            if (!(className.equals("ni") || className.equals("ni2"))) {
                                continue;
                            }
                            TableColumn[] tableColumns = tableRow.getColumns();
                            //国内彩票标识
                            rowData.add(domesticStr);
                            //周几
                            String day = MapUtils.getString(dayMapping, tableRow.getAttribute("name"));
                            //比赛序号
                            String number = tableColumns[0].getLastChild().toPlainTextString();

//                            System.out.println("比赛序号：" + number );

                            if( "竞彩暂没有开出当期赛事".equals(number))
                            {
//                                System.out.println(" inside if 比赛序号：" + number );
                                return;
                            }
                            //整体的比赛序号为：
                            number = day + number;
                            rowData.add(number);
                            TableColumn timeColumn = tableRow.getColumns()[2];
                            String time = "";
                            time = timeColumn.getAttribute("title").replaceAll("开赛时间：", "");
//                        String time = timeColumn.toPlainTextString();
                            rowData.add(time);
                            //次级序号默认从1开始
                            rowData.add(andicaph++);
                            //盘口等信息
                            TableColumn column = tableColumns[tableColumns.length - 1];
                            //tr节点下面又是一个子table
                            TableTag lastTable = (TableTag) column.getLastChild();
                            //分析子table，读取盘口等信息
                            TableRow[] childTableRows = lastTable.getRows();
                            for (int k = 0; k < childTableRows.length; k++) {
                                List<Object> tempDatas = new ArrayList<Object>();
                                TableRow childTableRow = childTableRows[k];
                                TableColumn[] childTableColumn = childTableRow.getColumns();
                                for (int m = 0; m < childTableColumn.length - 1; m++) {
                                    if (m == 0) {
                                        Node tempNode = childTableColumn[m].getChild(1);
                                        if (tempNode instanceof TextNode) {
                                            String text = tempNode.toPlainTextString();
                                            tempDatas.add(text.equals("&nbsp;") ? "0" : text);
                                        } else {
                                            tempNode = childTableColumn[m].getChild(2);
                                            String text = tempNode.toPlainTextString();
                                            tempDatas.add(text);
                                        }
                                    } else {
                                        tempDatas.add(childTableColumn[m].getFirstChild().toPlainTextString());
                                    }
                                }
                                if (childTableColumn.length == 1) {
                                    tempDatas.add("");
                                    tempDatas.add("");
                                    tempDatas.add("");
                                    tempDatas.add("");
                                }
//                            System.out.println(tempDatas);
                                if (k == 0) {
                                    rowData.addAll(tempDatas);
                                } else {
                                    rowData.add(domesticStr);
                                    rowData.add(number);
                                    rowData.add(time);
                                    rowData.add(andicaph++);
                                    rowData.addAll(tempDatas);
                                }
                            }
                            //国内彩票数据解析完毕，现在解析国外博彩公司赔率解析
                            TableColumn abroadColumn = tableColumns[tableColumns.length - 2];
                            LinkTag linkTag = (LinkTag) abroadColumn.getChild(2);
                            try {
                                parseAbroadData(linkTag.getLink(), rowData, number);
                            } catch (Exception e) {
                                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                            }
                            datas.add(rowData);
                        }
                        break;
                    }
                }
                context.setParserData(datas);
                //输出到文件

                outPut.print(context, playingway);
//            System.out.println(datas);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    /**
     * 解析国外数据,国外数据分析比较复杂，源网站是采用ajax技术刷新局部区域，然后用JavaScript构造的html
     * <p/>
     * 故直接访问源网站获取不到源码，也获取不到相应的博彩数据，只有读取源网站的逻辑，访问ajax地址，然后进行解析返回后的数据才可以
     *
     * @param url
     * @param data
     */
    private void parseAbroadData(String url, List<Object> data, String number) {
        //首先获取ajax网站地址，举例说明
        //http://www.310win.com/analysis/odds/949386.htm?1401437073000".
        String scheduleID = StringUtils.replaceOnce(url, "http://www.310win.com/analysis/", "").replaceAll("\\.htm", "");
        String newUrl = "http://www.310win.com/analysis/odds/" + scheduleID + ".htm";
        //获取隐藏域数据
        NodeFilter filter = new NodeClassFilter(InputTag.class);
        Parser parser = new Parser();
        try {
            parser.setURL(newUrl);
            parser.setEncoding("UTF-8");
            NodeList list = parser.extractAllNodesThatMatch(filter);
            if (list == null || list.size() == 0) {
                return;
            }
            InputTag inputTag = (InputTag) list.elementAt(0);
            String id = inputTag.getAttribute("id");
            //下面解析逻辑参考源网站js方法funcnew.js 中的oddsComp方法
            if (id == null || !id.equals("iframeAOdds")) {
                return;
            }
            String value = inputTag.getAttribute("value");
            String[] dataStr = value.split("\\^");
            List<String[]> childData = new ArrayList<String[]>();
            for (int i = 0; i < dataStr.length; i++) {
                childData.add(dataStr[i].split("\\;"));
            }
            for (String[] rowDatas : childData) {
                if (rowDatas != null && rowDatas.length == 4)
                    //要分析的公司数据
                    if (compaySet.contains(rowDatas[1])) {
                        data.add(abroadStr);
                        data.add(number);
                        data.add(rowDatas[1]);
                        //网站的及时数据
                        String[] tempData = rowDatas[3].split("\\,");
                        data.add(tempData[0]);
                        data.add(tempData[1]);
                        data.add(tempData[2]);
                        data.add(tempData[7]);
                        data.add(tempData[8]);
                        data.add(tempData[9]);
                    }
            }
        } catch (ParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}

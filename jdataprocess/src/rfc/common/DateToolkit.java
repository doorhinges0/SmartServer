package rfc.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public class DateToolkit {


    /**
     * 获取时间范围内的日期集合
     *
     * @param startdate 开始日期，格式：yyyy-mm-dd
     * @param enddate 结束日期，格式：yyyy-mm-dd
     *
     * @return List<String> 日期集合
     */
    public static List<String> getDayList(String startdate, String enddate) {
        List<String> dateList = new ArrayList<String>();
        try {

            DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
            Calendar startDay = Calendar.getInstance();
            Calendar endDay = Calendar.getInstance();
            startDay.setTime(FORMATTER.parse(startdate));
            endDay.setTime(FORMATTER.parse(enddate));

            Calendar currentPrintDay = startDay;

            while (true) {
                if (currentPrintDay.after(endDay)){
                    break;
                }
                dateList.add(FORMATTER.format(currentPrintDay.getTime()));

                // 日期加一
                currentPrintDay.add(Calendar.DATE, 1);

            }
        } catch (Exception e) {
            System.out.println("调用DateToolkit类的getCycleDayList方法报错！");
        }

        return dateList;
    }

    public static String yesterday(String pattern){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-1);
        return DateToolkit.formatUtilDate(c.getTime(), pattern);
    }

    /**
     * 将java.utils.Date类型的日期转换为pattern格式的日期字符串
     */
    public static String formatUtilDate(java.util.Date date, String pattern) {
        if (date == null)
            return "";
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public  static void main(String[] args){
        Date today = new Date();
        String strToday = formatUtilDate(today, DatePattern._YYYYMMDD.toString());
        String strEndday = "2017-09-18";

        String yesterday = yesterday(DatePattern.YYYYMMDD.toString());

        System.out.println(yesterday+","+strToday+","+strEndday);


        for (String day: getDayList(strEndday,strToday)) {
            System.out.print(day+",");
        }
    }

}

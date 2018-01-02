package com.rfc.util.common;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateToolkit {
	
	public static final String[] NORMAL_DATEFORMATS = new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd","yyyy-MM-dd HH:mm:ss.SSS","yyyyMMdd","yyyyMMddHHmmss","yyyy-MM-dd a","HH:mm:ss"};
	
	public static final String DEFAULT_DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE = "yyyy-MM-dd";
	
	/**
	 * 根据日期字符串，自动识别日期模式
	 */
	public static String normalDateFormat(String dateStr){
		for (String pattern : NORMAL_DATEFORMATS){
			if (isValidDateFormat(dateStr, pattern)){
				return pattern;
			}
		}
		return null;
	}
	
	/**
	 * 自动识别日期模式，并转换为java.utils.Data对象
	 * @param dateStr
	 * @return
	 */
	public static Date normalDate(String dateStr){
		String dateFormat = normalDateFormat(dateStr);
		return null != dateFormat ? utilStrToDate(dateStr, dateFormat) : null;
	}
	
	/**
	 * 将java.sql.Date类型的日期转换为yyyy-MM-dd格式日期字符串 注：只有日期
	 * 
	 */
	public static String sqlDateToStr(java.sql.Date date) {
		return formatSqlDate(date, "yyyy-MM-dd");
	}

	/**
	 * 将java.sql.Date类型的日期转换为pattern格式的日期字符串
	 * 
	 */
	public static String formatSqlDate(java.sql.Date date, String pattern) {
		if (date == null)
			return "";
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将yyyy-MM-dd格式的日期字符串转换为java.sql.Date类型
	 * 
	 * @throws Exception
	 */
	public static java.sql.Date strToSqlDate(String datetime){
		return strToSqlDate(datetime, "yyyy-MM-dd");
	}

	/**
	 * 将pattern格式的日期字符串转换为java.sql.Date类型
	 * 
	 * @throws Exception
	 */
	public static java.sql.Date strToSqlDate(String datetime, String pattern){
		java.sql.Date result = null;
		try {
			if ((datetime != null) && (datetime.length() > 0)) {
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				result = new java.sql.Date(format.parse(datetime).getTime());
			}
		} catch (Exception exp) {
			throw new RuntimeException("have a NG date format");
		}
		return result;
	}

	/**
	 * 将java.utils.Date类型的日期转换为“yyyy-MM-dd HH:mm:ss" 格式日期字符串<br>
	 * 注：只有日期，时，分，秒为零
	 */
	public static String utilDateToStr(Date date) {
		return formatUtilDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将java.utils.Date类型的日期转换为pattern格式的日期字符串
	 */
	public static String formatUtilDate(Date date, String pattern) {
		if (date == null)
			return "";
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将java.utils.Date类型的日期转换为pattern格式的日期字符串
	 */
	public static String formatUtilDate(Date date, String pattern, Locale locale) {
		if (date == null)
			return "";
		DateFormat format = new SimpleDateFormat(pattern, locale);
		return format.format(date);
	}

	/**
	 * 将“yyyy-MM-dd HH:mm:ss"格式的日期字符串转换为java.utils.Date类型
	 *
	 * @throws Exception
	 */
	public static Date utilStrToDate(String datetime){
		return utilStrToDate(datetime, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将pattern格式的日期字符串转换为java.utils.Date类型
	 *
	 * @throws Exception
	 */
	public static Date utilStrToDate(String datetime, String pattern){
		Date result;
		try {
			if ((datetime != null) && (datetime.length() > 0)) {
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				result = format.parse(datetime);
			} else {
				result = null;
			}
		} catch (Exception exp) {
			// 指定的日期字符串格式不对
			throw new RuntimeException("have a NG date format");
		}
		return result;
	}

	/**
	 * 比较两个日期相差多少个月，用d2 - d1
	 */
	public static int compareMonth(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);

		return (c1.get(Calendar.YEAR) - c2
				.get(Calendar.YEAR))
				* 12
				+ (c1.get(Calendar.MONTH) - c2
						.get(Calendar.MONTH));
	}

	/**
	 * 比较两个日期相差多少天，用d2 - d1
	 */
	public static int compareDate(Date d1, Date d2) {

		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * 比较两个日期相差多少秒，用d2 - d1
	 */
	public static int compareSecond(Date d1, Date d2) {

		return (int) (   (d2.getTime() - d1.getTime())/1000  );
	}

	/**
	 * 比较两个日期相差多少小时，用d2 - d1
	 */
	public static int compareHour(Date d1, Date d2) {

		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 ));
	}

	/**
	 * 比较两个日期相差多少个月，用d2 - d1
	 *
	 */
	public static int compareMonth(java.sql.Date d1, java.sql.Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);

		return (c1.get(Calendar.YEAR) - c2
				.get(Calendar.YEAR))
				* 12
				+ (c1.get(Calendar.MONTH) - c2
						.get(Calendar.MONTH));
	}
	

	/**
	 * @param year
	 * @param month
	 * @return 返回指定年月的开始时间 （yyyy-MM-dd 00:00:00）
	 */
	public static String getMonthBegin(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return formatUtilDate(calendar.getTime(), "yyyy-MM-dd") + " 00:00:00";
	}

	/**
	 * @param year
	 * @param month
	 * @return 返回指定年月的结束时间 （yyyy-MM-dd 23:59:59）
	 */
	public static String getMonthEnd(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 0);
		return formatUtilDate(calendar.getTime(), "yyyy-MM-dd") + " 23:59:59";
	}

	/**
	 * 获得当前帐务周期
	 * 
	 * @return valBillCyc
	 */
	public static Long getCurBillCyc() {
		Calendar cal = Calendar.getInstance();
		String curdate = formatUtilDate(cal.getTime(),
				"yyyyMMdd HH:mm:ss");
		String billcyc = curdate.substring(0, 6) + "00";
		Long valBillCyc = null;
		if (billcyc != null && !"".equals(billcyc)) {
			valBillCyc = new Long(billcyc);
		}
		return valBillCyc;
	}
	
	public static String yesterday(String pattern){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-1);
		return DateToolkit.formatUtilDate(c.getTime(), pattern);
	}
	
	public static String preMonth(String pattern){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		return new SimpleDateFormat(pattern).format(c
				.getTime());
	}
	
	/**
	 * 检查时间格式
	 * @param dateString
	 * @return
	 */
	public static boolean isVaidYYMMDD(String dateString){
		if (dateString == null)
			return false;
		return dateString.matches("^[1-9][0-9]{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$");
	}
	
	public static boolean isVaidYYMMDDHH(String dateString){
		if (dateString == null)
			return false;
		return dateString.matches("^[1-9][0-9]{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])([0-1][0-9]|2[0-3])$");
	}
	
	public static boolean isValidDateFormat(String dateStr,String exepctedFormat){
		try {
			utilStrToDate(dateStr, exepctedFormat);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static String todayStr(String pattern){
		if (pattern == null || "".equals(pattern)){
			pattern = "yyyyMMddHHmmss";
		}
		return formatUtilDate(new Date(), pattern);
	}

	public static String todayTime(String pattern){
		if (pattern == null || "".equals(pattern)){
			pattern = "yyyyMMdd_HHmmss";
		}
		return formatUtilDate(new Date(), pattern);
	}

    /** 
     * 根据年 月 获取对应的月份 天数 
     * */  
    public static int getDaysByYearMonth(int year, int month) {  
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  
	
    
    /**
     * 获取指定某年某月的日期集合
     * @param year
     * @param month
     * @return
     */
    public static List<String> getDaysListByYearMonth(int year,int month){
    	List<String> results = new ArrayList<String>();
    	Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE); 
        for (int i = 1; i <= maxDate; i++) {
        	
        	String monthStr = new Integer(month).toString();
        	if(monthStr.length()!=2){
        		monthStr = "0"+monthStr;
        	}
        	
        	String dayStr = new Integer(i).toString();
        	if(dayStr.length()!=2){
        		dayStr = "0"+dayStr;
        	}
        	
			String datetime = year+"-"+monthStr+"-"+dayStr;
			results.add(datetime);
		}
   
    	return results;
    }
	
    public static Date getlastMonthDate(Date date){
    	String str = DateToolkit.formatUtilDate(date, "yyyy-MM-dd");
    	int year = Integer.valueOf(str.substring(0, 4));
    	int month = Integer.valueOf(str.substring(5, 7));
    	if(month==0){
    		year = year-1;
    		month = 12;
    	}else{
    		month = month-1;
    	}
    	String monthStr = new Integer(month).toString();
    	if(monthStr.length()!=2){
    		monthStr = "0"+monthStr;
    	}
    	str = String.valueOf(year)+"-"+monthStr+"-01";
    	return utilStrToDate(str, "yyyy-MM-dd");
    }
    
    /** 
     * 获取当月的 天数 
     * */  
    public static int getCurrentMonthDay() {  
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    } 
	
	
    /** 
     * 根据日期 找到对应日期的 星期 
     */  
    public static String getDayOfWeekByDate(String date) {  
        String dayOfweek = "-1";  
        try {  
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");  
            Date myDate = myFormatter.parse(date);  
            SimpleDateFormat formatter = new SimpleDateFormat("E");  
            String str = formatter.format(myDate);  
            dayOfweek = str;  
              
        } catch (Exception e) {  
            System.out.println("错误!");  
        }  
        return dayOfweek;  
    } 
    
    //milliseconds
    public static Long minusTime(Date d1,Date d2){
    	return d1.getTime() - d2.getTime();
    }
	
    public static Date getStartOfDay(){
    	return new DateTime().withTimeAtStartOfDay().toDate();
    }
	
	public static Date getEndOfDay(){
		return new DateTime().plusDays(1).withTimeAtStartOfDay().minusMillis(1).toDate();
	}
	
	public static Date minus(Date date,long sub){
		return new DateTime(date.getTime()).minus(sub).toDate();
	}
	
	/**
	 * 获取当前时间前sub天的日期
	 * @param sub
	 * @return
	 */
	public static Date minus(long sub){
		return minus(new Date(), sub);
	}
	
	

	
	/**
	 * 获取时间范围内的日期集合
	 * 
	 * @param startdate 开始日期，格式：yyyy-mm-dd
	 * @param enddate 结束日期，格式：yyyy-mm-dd
	 * 
	 * @return List<String> 日期集合
	 */
	public static List<String> getDayList(String startdate,String enddate) {
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
	
	
	
	/**
	 * 获取时间范围内的日期集合(排除掉某个星期几后的日期集合)
	 * 
	 * @param startdate 开始日期，格式：yyyy-mm-dd
	 * @param enddate 结束日期，格式：yyyy-mm-dd
	 * @param weekdayname 星期几，多个星期间以“，”号分割 （星期的英文，值为：sunday,monday,tuesday,wednesday,thursday,friday,saturday）
	 * 
	 * @return List<String> 日期集合
	 */
	public static List<String> getDayListContainAppointWeekdays(String startdate,String enddate,String weekdaynames) {
		
		List<String> newDayList = new ArrayList<String>();
		
		String[] weeknameArr = weekdaynames.split(",");

		List<String> alldayList = getDayList(startdate,enddate);
		for (String dayStr : alldayList) {
			
			String weekname = JodaTimeUtils.getDesignatedDayWeekCode(dayStr);
			
			for (int i = 0; i < weeknameArr.length; i++) {
				String name = weeknameArr[i];
				
				if(name.equals(weekname)){
					newDayList.add(dayStr);
				}
				
			}

		}
		
		return newDayList;
	}
	
	
	

	/**
	 * 获取某年某月的第几周的所有日期（int[]）
	 * 
	 * @param year 年
	 * @param month 月
	 * @param week 周
	 * 
	 * @return int[] 周对应的天数集合
	 */
	public static int[] getOneMonthWeekDays(int year, int month, int week){
		
		month = month - 1;//月份从0开始，所以减去1
		
		int size = 7;
		
		int[] weekDays = new int[size];
		  
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		  
		calendar.set(Calendar.WEEK_OF_MONTH, week);
		  
		for(int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++){
			 weekDays[i-1] = calendar.get(Calendar.DAY_OF_MONTH);
			 calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		return weekDays;
	}
	
	
	
	/**
	 * 获取某年某月的第几周的所有日期（String）
	 * 
	 * @param year 年
	 * @param month 月
	 * @param week 周
	 * 
	 * @return String 周对应的天数集合字符串，如："29,30,1,2,3,4,5"
	 */
	public static String getOneMonthWeekDaysToString(int year, int month, int week){
		String weekStr = "";
		StringBuffer sb = new StringBuffer();
		int[] weeks = getOneMonthWeekDays(year,month,week);
		for (int i = 0; i < weeks.length; i++) {
			sb.append(weeks[i]).append(",");
		}
		weekStr = sb.toString();
		weekStr = weekStr.substring(0, weekStr.length()-1);

		return weekStr;
	}
	
	/**
	 * 把小时分转为分
	 * @param time 
	 * 
	 * @return  具体的分钟数目，如8:30等于510分钟
	 */
	public static Integer transferTimeToMinutes(String time){
		
		String [] array = time.split(":");
		if(array.length == 2){
			return Integer.parseInt(array[0])*60 + Integer.parseInt(array[1]);
		}else
			return 0;
	}
	
	/**
	 * 根据开始日期设置小时数
	 * @param Date
	 * 
	 * @return String
	 */
	public static String transferDateToHours(Date starttime) {
		
		if(starttime!=null){
			int durationDay = DateToolkit.compareHour(starttime, new Date());//持续小时
			return new Integer(durationDay).toString()+"H";
		}else{
			return "0H";
		}
	}
	
	/**
	 * 查找两个月份之间的所有月份
	 * @param startMonth(2016-09)
	 * @param endMonth(2016-12)
	 * @return
	 */
	public static List<String> getMonth(String startMonth, String endMonth) {
		List<String> listStr = new ArrayList<String>();
		if(StringUtils.isNotBlank(startMonth) && StringUtils.isNotBlank(endMonth)) {
			int starty = Integer.valueOf(startMonth.substring(0,4));
			int endy = Integer.valueOf(endMonth.substring(0,4));
			int startm = Integer.valueOf(startMonth.substring(5));
			int endm = Integer.valueOf(endMonth.substring(5));
			String month = "";
			for(int j = starty; j <= endy; j++) {
				if(j == starty && j == endy) {
					for(int i = startm; i<=endm; i++) {
						if(i < 10) {
							month = String.valueOf(j) + "-0" + String.valueOf(i);
						}else{
							month = String.valueOf(j) + "-" + String.valueOf(i);
						}
						listStr.add(month);
					}
				}else if(j == starty && j != endy) {
					for(int i = startm; i<=12; i++) {
						if(i < 10) {
							month = String.valueOf(j) + "-0" + String.valueOf(i);
						}else{
							month = String.valueOf(j) + "-" + String.valueOf(i);
						}
						listStr.add(month);
					}
				}else if(j != starty && j == endy) {
					for(int i = 1; i<=endm; i++) {
						if(i < 10) {
							month = String.valueOf(j) + "-0" + String.valueOf(i);
						}else{
							month = String.valueOf(j) + "-" + String.valueOf(i);
						}
						listStr.add(month);
					}
				}else {
					for(int i = 1; i<=12; i++) {
						if(i < 10) {
							month = String.valueOf(j) + "-0" + String.valueOf(i);
						}else{
							month = String.valueOf(j) + "-" + String.valueOf(i);
						}
						listStr.add(month);
					}
				}
			}
		}
		return listStr;
	}
	
	/**
	 * 获取指定日期属于一年中的第几周
	 * @param date
	 * @return
	 */
	public static int getDateOfWeekInYear(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * 获取指定日期的前或后n天的时间，返回为pattrn格式的日期时间
	 * @param date
	 * @param n
	 * @param pattern
	 * @return
	 */
	public static String getSubDate(Date date,int n,String pattern){
		Date getDate = new Date(date.getTime()+ 86400000L*n);
		return formatUtilDate(getDate,pattern);
	}
	
	/**
	 * 获取指定日期的前或后n天的时间，返回为Date格式的日期时间
	 * @param date
	 * @param n
	 * @param pattern
	 * @return
	 */
	public static Date getSubDate(Date date,int n){
		Date getDate = new Date(date.getTime()+ 86400000L*n);
		return getDate;
	}
}


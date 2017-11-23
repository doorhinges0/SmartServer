package com.fuck.mobile.base.utils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @category 通用有用类
 * @author liwenbin
 *
 */
public class COMMON {
    private static final Log log = LogFactory.getLog(COMMON.class);
    
    public static final String RETURL = "ret";
	public static String AppName;
	public static  boolean isInROOT;
    /**
     * 取得路径
     * @param request
     * @param server：true=取得的是server的路径;false=client
     * @return
     * @author 
     */
    public static String getPath(HttpServletRequest request, boolean server) {
        String scheme = request.getScheme().toLowerCase();
        int serverPort = request.getServerPort();
        StringBuffer path = new StringBuffer();
        if (server) {
            path.append(scheme).append("://").append(request.getServerName().toLowerCase());
            if (isEmpty(serverPort) || ("http".equals(scheme) && 80 == serverPort)
                    || ("https".equals(scheme) && 443 == serverPort)) {
            }
            else {
                path.append(":" + serverPort);
            }
            path.append(request.getContextPath());

            if (!path.toString().endsWith("/")) {
                path.append("/");
            }
        }
        else {
            path.append(scheme).append("://").append(request.getRemoteHost());
        }

//        if (log.isDebugEnabled()) {
//            log.debug("basePath：" + path);
//        }
        return path.toString();
    }

    /**
     * 取得客户端真实ip
     * @param request
     * @return
     * @author 
     */
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     * 判断某个对象是否为空 集合类、数组做特殊处理
     * @param obj
     * @return 如为空，返回true,否则false
     * @author 
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null)
            return true;

        // 如果不为null，需要处理几种特殊对象类型
        if (obj instanceof String) {
            return obj.equals("");
        }
        else if (obj instanceof Collection) {// 对象为集合
            Collection<?> coll = (Collection<?>) obj;
            return coll.size() == 0;
        }
        else if (obj instanceof Map) {// 对象为Map
            Map<?, ?> map = (Map<?, ?>) obj;
            return map.size() == 0;
        }
        else if (obj.getClass().isArray()) {// 对象为数组
            return Array.getLength(obj) == 0;
        }
        else {// 其他类型，只要不为null，即不为empty
            return false;
        }
    }

    /***
     * {取得指定字符指定第几次出现的所在整个字符串的索引位置}
     * @param str
     * @param matchStr 指定字符匹配
     * @param count     指定第几次出现的匹配
     * @return
     * @author: 梁云洪
     */
    public static int getIndex(String str, String matchStr, int count) {
        int counter = 0;
        int counter2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (matchStr.equals(String.valueOf(str.charAt(i)))) {
                counter2++;
                if (counter2 == count) {
                    return i;
                }
            }
        }
        return counter;
    }

    public static String alertTipsAndReturn(String tips, String retUrl) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\">").append("alert('").append(tips).append("');")
                .append("document.location.href='").append(retUrl).append("';</script>");
        return sb.toString();
    }

    public static String goBack(String tips) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\">").append("alert('").append(tips)
                .append("');window.history.back();").append("</script>");
        return sb.toString();
    }

    /**
     * 去除null以及空格串，返回string
     * @return:
     * @author: liangyunhong
     */
    public static String noNull(Object s) {
        if (s == null)
            return "";
        else
            return s.toString().trim();
    }

    /**
     * 获取文件的真实后缀名。目前只支持JPG, GIF, PNG, BMP四种图片文件。
     * 
     * @param bytes 文件字节流
     * @return JPG, GIF, PNG or null
     */
    public static String getFileSuffix(byte[] bytes) {
        if (bytes == null || bytes.length < 10) {
            return null;
        }

        if (bytes[0] == 'G' && bytes[1] == 'I' && bytes[2] == 'F') {
            return "GIF";
        }
        else if (bytes[1] == 'P' && bytes[2] == 'N' && bytes[3] == 'G') {
            return "PNG";
        }
        else if (bytes[6] == 'J' && bytes[7] == 'F' && bytes[8] == 'I' && bytes[9] == 'F') {
            return "JPG";
        }
        else if (bytes[0] == 'B' && bytes[1] == 'M') {
            return "BMP";
        }
        else {
            //return "JPG";
            return "";
        }
    }

    /**
     * 根据cookie name在cookie数组中查找对应的cookie对象
     * @param name
     * @param cookie
     * @return
     * @author 
     */
    public static Cookie findCookieByName(String name, Cookie[] cookie) {
        if (cookie != null && cookie.length > 0) {
            for (Cookie temp : cookie) {
                if (name.equals(temp.getName()) && !COMMON.isEmpty(temp.getValue())) {
                    return temp;
                }
            }
        }
        return null;
    }

    /**
     * {将含有html里的标签全部去掉，得到标签之间的内容<br>
     * str如：<p><strong>【活动详情】</strong></p><p align=\"center\"><font size=\"6\"><font color=\"#ff0000\">测试啊 330</</font></font><font color=\"#0000ff\"><strong>（需使用58 或以上 ）</strong>}
     * @param str   
     * @param beginChar=标签开始字符如<、[
     * @param endChar=标签结束字符如>、]
     * @return
     * @author: 梁云洪
     */
    public static String filtPack(String str, char beginChar, char endChar) {
        char[] cc = str.trim().toCharArray();
        StringBuffer sb2 = new StringBuffer();
        boolean b = false;
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] == endChar) {
                b = true;
            }

            if (cc[i] == beginChar) {
                b = false;
            }

            if (b && cc[i] != endChar && cc[i] != beginChar) {
                sb2.append(cc[i]);
            }
        }
        return sb2.toString();
    }

    /**
     * 产生一个从start(包含)到end(不包含)的随机数
     * @param start
     * @param end
     * @return
     */
    public static int getIntRandom(int start, int end) {
        Random rnd = new Random();
        return start + rnd.nextInt(end - start);
    }

    /**  
     * 提供精确的加法运算。  
     * @param v1 被加数  
     * @param v2 加数  
     * @return 两个参数的和  
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 隐藏的的字段的部分信息，一般是email或者手机号码，如果是手机号码，严格要求是标准格式11位数字
     * @param field 
     * @return
     * @author 
     */
    public static String hiddenField(String field) {
        if (isEmpty(field)) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        if (field.contains("@")) {
            int atIndex = field.indexOf("@");
            String suffix = field.substring(atIndex);
            field = field.substring(0, atIndex);
            String begin = field.substring(0, 1);
            String end = field.substring(atIndex - 1, atIndex);

            if (field.length() == 1) {
                sb.append("*");
            }
            else if (field.length() == 2) {
                sb.append("*");
                sb.append(end);
            }
            else {
                sb.append(begin);
                for (int i = 0; i < field.length() - 2; i++) {
                    sb.append("*");
                }
                sb.append(end);
            }
            sb.append(suffix);
        }
        else if (field.length() == 11) {//需要是标准11位数字
            sb.append(field.substring(0, 3) + "****" + field.substring(7));
        }
        return sb.toString();
    }


    /**
     * 根据referer获取来源的页面名称
     * @author 
     */
    public static String getRefererPage(HttpServletRequest request) {
        try {
            if (request == null) {
                return "";
            }

            String referer = request.getHeader("Referer");
            if (isEmpty(referer)) {
                return "";
            }

            String arr[] = referer.split(".html")[0].split("/");
            String prePage = arr[arr.length - 1];
            log.info("Referer:" + referer + "#prePage:" + prePage);
            return prePage;
            //mv.addObject("prepage", arr[arr.length - 1]);//从哪个页面进来的页面名称，如：http://183.2.40.97:8090/YuMingWeb/usCenter/go/fbTradePassword.html，则得到是fbTradePassword，注意只适合此种类型的url，url后有参数也适用
        }
        catch (Exception e) {
        }
        return "";
    }

    /**
     * 对double数字取两位小数点，进行四舍五入
     * @param d
     * @return
     * @author 
     */
    public static double setScale(double d) {
        return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    
    public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
    
    
    
    public static String getPhoneType(HttpServletRequest request){
    	String phoneType= "";
    	String userAgent = request.getHeader("User-Agent");
    	if(userAgent.indexOf("iPhone")>-1){
    		phoneType="iPhone";
    	}else if(userAgent.indexOf("iPad")>-1){
    		phoneType="iPad";
    	}else if(userAgent.indexOf("Android")>-1){
    		phoneType="Android";
    	}else if(userAgent.indexOf("AppleWebKit")>-1){//苹果、谷歌内核                   
    		phoneType="webKit";
    	}else if(userAgent.indexOf("Trident")>-1){//IE内核
    		phoneType="Trident";
    	}else if(userAgent.indexOf("Presto")>-1){//opera内核             
    		phoneType="Presto";
    	}else if(userAgent.indexOf("Gecko")>-1 && userAgent.indexOf("KHTML")==-1){//火狐内核 内核             
    		phoneType="gecko";
    	}
    	
    	return phoneType;
    }
    public static void main(String[] args) {
        System.out.println(0.3 - 0.1);
        // System.out.println(setScale(0.3 - 0.01));
        //System.out.println(187.655 / 100);
    }
}

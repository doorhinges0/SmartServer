package com.fuck.mobile.base.utils;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fuck.mobile.base.common.AjaxActionResult;

/**
 * 
 * @category 工具类，利用gson对json/bean之间的互转：json转bean、bean转json
 * @author liwenbin
 *
 */
public class ControllerUtil {
    private static final Log log = LogFactory.getLog(ControllerUtil.class);

    public static final String CONTENTTYPE_JSON = "text/json";

    public static final String CONTENTTYPE_HTML = "text/html";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_FORMAT1 = "yyyy-MM-dd HH:mm:ss";

    /**
     * {反序列化：将请求转换成对象，即json转换成bean。可映射Controller中多个对象、变量等}
     * @param request
     * @param ctrlObj   controller对象
     * @param dateFormat TODO
     * @throws Exception
     * @author liwenbin
     */
    public static void jsonToBean(HttpServletRequest request, Object ctrlObj, String dateFormat) throws Exception {
        //parameterName实际提交过来只有一个，例如一大串：{"page":{"begin":0,"max":10,"orderBy":"TEST_ID asc"},"test":{"testName":"titleName"}}
        Enumeration<?> e = request.getParameterNames();
        String json = "";
        if (e.hasMoreElements()) {
            json = e.nextElement().toString();
        }
        if (log.isDebugEnabled()) {
            log.debug(json);
        }

        //modify 20120613
        Gson gson = null;
        if (dateFormat == null) {
            gson = new GsonBuilder().create();
        }
        else {
            gson = new GsonBuilder().setDateFormat(dateFormat).create();
        }

        Object ctrlObj2 = gson.fromJson(json, ctrlObj.getClass());
        Field field[] = ctrlObj.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            if (field[i].getDeclaredAnnotations().length == 0 && !Modifier.isFinal(field[i].getModifiers())
                    && !Modifier.isStatic(field[i].getModifiers())) {
                field[i].setAccessible(true);
                field[i].set(ctrlObj, field[i].get(ctrlObj2));
            }
        }
    }

    /**
     * {序列化：将列表数据转换成json进行响应}
     * @param response
     * @param list      列表数据
     * @param totalRows 总记录数
     * @return
     * @throws Exception
     * @author liwenbin
     */
    public static ModelAndView pageListToJson(HttpServletResponse response, List<?> list, long totalRows,
            String dateFormat) throws Exception {

        if (COMMON.isEmpty(dateFormat)) {
            dateFormat = DEFAULT_DATE_FORMAT;
        }

        Gson gson = new GsonBuilder().setDateFormat(dateFormat).create();
        String json = gson.toJson(list);
        PrintWriter pw = null;
        try {
            response.setContentType("text/json;charset=utf-8");
            pw = response.getWriter();
            String responseJson = "{\"totalRows\":" + totalRows + ",\"list\":" + json + "}";
            if (log.isDebugEnabled()) {
                log.debug(responseJson);
            }
            pw.write(responseJson);
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (pw != null) {
                pw.close();
            }
        }
        return null;
    }

    /**
     * {将响应内容转换成json格式后，进行响应输出}
     * @param response
     * @param contentType   输出内容的类型
     * @param sign      响应内容
     * @throws Exception
     * @author liwenbin
     */
    public static void toJson(HttpServletResponse response, String contentType, String sign) throws Exception {
        PrintWriter pw = null;
        try {
            response.setContentType(contentType + ";charset=utf-8");
            pw = response.getWriter();
            String s = "{\"result\":\"" + sign + "\"}";
            if (log.isDebugEnabled()) {
                log.debug(s);
            }
            pw.write(s);
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    /**
     * {将json格式的内容直接响应输出}
     * @param response
      *@param contentType   输出内容的类型
     * @param json      json string
     * @throws Exception
     * @author liwenbin
     */
    public static void writeJson(HttpServletResponse response, String contentType, String json) throws Exception {
        PrintWriter pw = null;
        try {
            response.setContentType(contentType + ";charset=utf-8");
            pw = response.getWriter();
            if (log.isDebugEnabled()) {
                log.debug(json);
            }
            pw.write(json);
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    /**
     * {将json格式的内容直接响应输出}
     * @param response
      *@param contentType   输出内容的类型
     * @param json      json string
     * @throws Exception
     * @author liwenbin
     */
    public static void writeMap(HttpServletResponse response, Map<?, ?> args) throws Exception {
        OutputStream os = null;
        try {
            response.setContentType("text/json;charset=utf-8");
            os = response.getOutputStream();
            if (log.isDebugEnabled()) {
                log.debug(args.toString());
            }
            os.write(new Gson().toJson(args).getBytes("utf-8"));
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (os != null) {
                os.close();
            }
        }
    }

    /**
     * {将json格式的内容直接响应输出}
     * @param response
      *@param contentType   输出内容的类型
     * @param json      json string
     * @throws Exception
     * @author liwenbin
     */
    public static void printMap(HttpServletResponse response, Map<?, ?> args) throws Exception {
        PrintWriter pw = null;
        try {
            response.setContentType("text/json;charset=utf-8");
            pw = response.getWriter();
            String json = new Gson().toJson(args);
            if (log.isDebugEnabled()) {
                log.debug(json);
            }
            pw.print(json);
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public static void writeAjaxResult(HttpServletResponse response, String message, boolean success) {
        AjaxActionResult ajresult = new AjaxActionResult();
        ajresult.setSuccess(success);
        ajresult.setMessage(message);
        PrintWriter pw = null;
        try {
            response.setContentType("text/json;charset=utf-8");
            pw = response.getWriter();
            pw.write(ajresult.getJSONString());
            pw.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}

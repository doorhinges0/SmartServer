package com.sunrise.common.utils.bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sunrise.common.utils.date.DateToolkit;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.common.utils.string.StringToolkit;

public class ParamParser {
    private static final Logger log = LoggerFactory.getLogger(ParamParser.class);
    private String paramXml;
    private Object valueSource;
    
    private String interfaceId;

    public ParamParser(String paramXml, Object valueSource,String interfaceId) {
        this.paramXml = paramXml;
        this.valueSource = valueSource;
        this.interfaceId = interfaceId;
    }

    public List getParams() {
        List results = new ArrayList();
        try {
            Document doc = DocumentHelper.parseText(paramXml);
            List paramList = doc.selectNodes("params/param");
            if (paramList != null && paramList.size() > 1) {
                for (Iterator it = paramList.iterator(); it.hasNext();) {
                    Element pElt = (Element) it.next();
                    String name = pElt.attributeValue("name");
                    String type = pElt.attributeValue("type");
                    Object result = getParam(name);
                    if (!StringToolkit.isEmpty(type) && type.equals("String")) {
                        result = result.toString();
                    } else if (!StringToolkit.isEmpty(type)
                            && type.equals("DateString")) {
                        String pattern = pElt.attributeValue("pattern");
                        if (StringToolkit.isEmpty(pattern)) {
                            pattern = "yyyy-MM-dd HH:mm:ss";
                        }
                        result = DateToolkit.formatUtilDate((Date)result, pattern);
                    }
                    results.add(result);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            if (log.isInfoEnabled()){
                log.info("解析接口[" + interfaceId + "]的参数类型定义出错!");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if (log.isInfoEnabled()){
                log.info("获取接口[" + interfaceId + "]的参数对象出错!");
            }
        }

        return results;
    }
    
    public  Object getParam(String name){
        List nameList = new ArrayList();
        List idxList = new ArrayList();
        List keyList = new ArrayList();
        Object bean = valueSource;
        try {
            ParserUtil.analyzeName(name, nameList, idxList, keyList);
            String tName = "";
            while (nameList.size() > 0){
                tName = (String)nameList.get(0);
                nameList.remove(0);
                if (ParserUtil.IDX_MODEL.equals(tName)){
                    int index = ((Integer)idxList.get(0)).intValue();
                    idxList.remove(0);
                    bean = this.getIdxProperty(bean, index);
                }else if (ParserUtil.MAP_MODEL.equals(tName)){
                    String key = (String)keyList.get(0);
                    keyList.remove(0);
                    bean = this.getMapProperty(bean, key);
                }else if (ParserUtil.NESTED_MODEL.equals(tName)){
                    continue;
                }else {
                    bean = BeanUtils.getProperty(bean, tName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    
    public Object getIdxProperty(Object bean,int index){
         if (!bean.getClass().isArray()) {
                if (!(bean instanceof java.util.List)) {
                    if (log.isInfoEnabled()){
                        log.info("Object '" + bean.getClass().getName()
                                + "' is not indexed");
                    }
                    return null;
                } else {
                    //get the List's value
                    return ((java.util.List) bean).get(index);
                }
            } else {
                //get the array's value
                return (Array.get(bean, index));
            }
    }
    
    public Object getMapProperty(Object bean,String key){
        if (bean instanceof java.util.Map){
            return ((Map)bean).get(key);
        }else {
            if (log.isInfoEnabled()){
                log.info("Object '" + bean.getClass().getName()
                        + "' is not Map type");
            }
            return null;
        }
    }

    public String getParamXml() {
        return paramXml;
    }

    public void setParamXml(String paramXml) {
        this.paramXml = paramXml;
    }

    public Object getValueSource() {
        return valueSource;
    }

    public void setValueSource(Object valueSource) {
        this.valueSource = valueSource;
    }
}

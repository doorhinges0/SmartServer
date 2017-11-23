package com.sunrise.common.utils.bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanParser {
	private static final Logger log = LoggerFactory.getLogger(BeanParser.class);
    private Object valueSource;

    public BeanParser(Object valueSource) {
        this.valueSource = valueSource;
    }
    
    public  Object getProperty(Object bean,String name){
        List nameList = new ArrayList();
        List idxList = new ArrayList();
        List keyList = new ArrayList();
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

    public Object getValueSource() {
        return valueSource;
    }

    public void setValueSource(Object valueSource) {
        this.valueSource = valueSource;
    }
}

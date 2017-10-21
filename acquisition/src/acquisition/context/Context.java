package acquisition.context;

import org.apache.commons.collections.MapUtils;

import javax.swing.plaf.InputMapUIResource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Copyrights @ 2011,Tianyuan DIC Information Co.,Ltd. All rights reserved.<br>
 *
 * @author 张伟
 * @description <br>
 * @date 2014-05-29 16:32
 */
public class Context {

    /**
     * 程序上下文配置
     */
    private Map<String, String> config = new HashMap<String, String>();

    /**
     * 上下文动态属性
     */
    private Map<String, Object> attributes = new HashMap<String, Object>();

    private List<List> parserData;

    public List<List> getParserData() {
        return parserData;
    }

    public void setParserData(List<List> parserData) {
        this.parserData = parserData;
    }

    public static String join(List array, String spliter) {
        if (array != null && array.size() > 0) {
            StringBuffer rs = new StringBuffer();
            for (int i = 0; i < array.size() - 1; i++) {
                rs.append(array.get(i) + (spliter == null ? "" : spliter));
            }
            rs.append(array.get(array.size() - 1));
            return rs.toString();
        }
        return "";
    }

    /**
     * 获取上下文
     *
     * @return
     */
    public static Context getContext() {
        Context context = new Context();
        context.initContxt();
        return context;
    }


    public void initContxt() {
        //获取配置文件
        Properties properties = new Properties();
        try {
            InputStream in = getClass().getResourceAsStream("/conf.properties");
            properties.load(in);
            Enumeration enu2 = properties.propertyNames();
            while (enu2.hasMoreElements()) {
                String key = (String) enu2.nextElement();
                this.config.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            System.out.println("未查找到相应的配置文件");
            e.printStackTrace();
        }

    }

    /**
     * 获取配置信息
     *
     * @param key
     * @return
     */
    public String getConfig(String key, String defaultValue) {
        return MapUtils.getString(config, key, defaultValue);
    }


    /**
     * 获取配置信息
     *
     * @param key
     * @return
     */
    public String getConfig(String key) {
        return MapUtils.getString(config, key);
    }

}

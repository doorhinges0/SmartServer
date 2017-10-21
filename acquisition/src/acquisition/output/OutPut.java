package acquisition.output;

import acquisition.context.Context;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Copyrights @ 2011,Tianyuan DIC Information Co.,Ltd. All rights reserved.<br>
 *
 * @author 张伟
 * @description <br>
 * @date 2014-05-30 16:54
 */
public class OutPut {

    private File m_indexFile;
    private String m_dir;
    private List m_fileNames;

    public OutPut(Context context) {
        m_dir = context.getConfig("outputDir");
        //m_indexFile = new File(new File(m_dir), "OutputInfo.txt");
        m_indexFile = null;
        m_fileNames = new ArrayList();
    }

    /**
     * 对外输出文件
     *
     * @param context
     */
    public void print(Context context, String playingway) {
        String fileName = playingway + "_data_" + getCurrentDay("yyyyMMdd_HHmmss") + ".txt";
        //String dir = context.getConfig("outputDir");
        String dir = m_dir;
        if (StringUtils.isEmpty(dir)) {
            System.out.println("输出目录未填写，文件输出失败！");
            return;
        }
        File file = new File(dir);
        if (!file.exists()) {
            try {
                FileUtils.forceMkdir(file);
            } catch (IOException e) {
                System.out.println("创建目录文件【" + dir + "】失败！");
                return;
            }
        }
        //将数据写入文件
        //file = new File(file, fileName);
        List<List> data = context.getParserData();
        List<String> dateLines = new ArrayList<String>();
        try {
            for (List rowData : data) {
                dateLines.add(Context.join(rowData, "|"));
            }
            if (dateLines.size() == 0)
                return;
            else
            {
                file = new File(file, fileName);
            }

            FileUtils.writeLines(file, dateLines);
            //写入索引目录文件
            //file = new File(new File(dir), "OutputInfo.txt");
            //List fileNames = new ArrayList();
            m_fileNames.add(fileName);
            //FileUtils.writeLines(file, fileNames,false);
            if ((playingway.equals(new String("single"))) || (m_indexFile == null)) {
               // System.out.println(" playingway equals all ");
                /*
                try{
                    System.out.println(" sleep 10m  ");
                    //Thread.currentThread().sleep(10000);
                }catch (Exception e) {
                    System.out.println("写入数据到文件【" + fileName + "】失败！");
                    return;
                }
                */
                try{
                    Thread.currentThread().sleep(5000);
                }catch (Exception e) {
                    System.out.println("sleep 5秒钟失败 ！");
                    return;
                }

                m_indexFile = new File(new File(m_dir), "source_file.txt");
                FileUtils.writeLines(m_indexFile, m_fileNames, false);

            }


        } catch (IOException e) {
            System.out.println("写入数据到文件【" + fileName + "】失败！");
            return;
        }
    }


    /**
     * 得到当前时间新增多少天之后的数据
     *
     * @param dateFormat 格式化
     * @return
     * @author 李国民
     */
    public static String getCurrentDay(String dateFormat) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);// 可以方便地修改日期格式
        //获取当前日期
        String nowDay = sdf.format(c.getTime());
        return nowDay;
    }


    /**
     * 判断outputInfo文件是否存在，存在此文件停止采集
     *
     * @return
     */
    public static boolean isRun(Context context) {
        String dir = context.getConfig("outputDir");
        if (StringUtils.isEmpty(dir)) {
            System.out.println("输出目录未填写，文件输出失败！");
            return false;
        }
       // File file = new File(new File(dir), "OutputInfo.txt");
        File file = new File(new File(dir), "source_file.txt");
        return !file.exists();
    }

}

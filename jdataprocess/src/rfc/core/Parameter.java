package rfc.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import rfc.common.Const;
import rfc.common.FileToolkit;
import rfc.common.ResourceUtils;
import rfc.entity.ParameterEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/8/12.
 */
public class Parameter {

    private String m_ParameterFile;
    private List<ParameterEntity> All_Parameter;
    private  int  Parameter_Num;

    public Parameter(String m_ParameterFile) {
        this.m_ParameterFile = m_ParameterFile;
        Parameter_Num = 0;
    }

    public  int GetRecord()  {
        ParameterEntity pe = new ParameterEntity();
        String	SB_Values = null ;
        String	Bet_Values = null ;
        File file = null;
        try {
            file = ResourceUtils.getFile(m_ParameterFile);

            if (!file.exists()){
                System.out.println("Parameter文件不存在: "+ m_ParameterFile);
                return -1;
            }

            LineIterator it = FileUtils.lineIterator(file, "GBK");
            while (it.hasNext()){
              String[] words = it.nextLine().split("|");
              pe.caItem = words[0];
              pe.caValues = words[1];
              All_Parameter.add(pe);
              Parameter_Num++;
              if (words[0].equals(Const.SB))
                  SB_Values = words[1];
              else if (words[0].equals(Const.BET))
                  Bet_Values = words[1];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ((!"Y".equals(SB_Values)) && (!"Y".equals(Bet_Values)))
        {
            System.out.println("SB与Bet的参数值至少有一个必须设置为Y!");
            return -11030;
        }
        return 0;
    }

    public  int FindRecord(String caItem, ParameterEntity ptParameter){
        boolean caFindId = false;

        if (Parameter_Num ==0)
            return -10010;
        for (ParameterEntity he :All_Parameter) {
            if (caItem.equals(he.caItem)){
                ptParameter =he;
                caFindId = true;
                break;
            }
        }
        if (caFindId)
            return -10020;
        return 0;
    }

    public  void Output(){
        for (ParameterEntity he :All_Parameter) {
            System.out.println(he.caItem+","+he.caValues);
        }
    }


}
